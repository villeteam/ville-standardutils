package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Phatency on 23.7.2015.
 */ // TODO: Generate an easy-to-read ID for all objectstates while reading the tree.
// Maybe there should exist an ObjectStateFactory of which all ObjectStates have a reference to?
// TODO: Support for collections?
public abstract class AbstractObjectState {
    private final AbstractObjectState parent;
    private Object value; // TODO: it may not be a good idea to hold references to all objects
    // might not be smart to store these always, might be an option to do for only leaves / primitive types?
    // this might sometimes be set to a placeholder object which only tells the type it is supposed to refer to and its former address?
    private boolean isRead;

    public AbstractObjectState(Object value, AbstractObjectState parent) {
        this.value = value;
        this.parent = parent;
    }

    public AbstractObjectState(Object value) {
        this(value, null); // no parent
    }

    public AbstractObjectState getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    /**
     * Performs DFS on the root node of this tree.
     *
     * @param value
     * @return
     */
    public Optional<AbstractObjectState> find(Object value) {
        AbstractObjectState root = getRoot();
        return root.findImpl(value);
    }

    protected Optional<AbstractObjectState> findImpl(Object value) {
        if (this.getValue().equals(value)) {
            return Optional.of(this);
        }
        return stream()
                .map(x -> x.getValue().findImpl(value))
                .filter(x -> x.isPresent())
                .findAny()
                .orElse(Optional.empty());
    }

    // TODO: No recursion for no reason
    public AbstractObjectState getRoot() {
        if (hasParent()) {
            return getParent().getRoot();
        }
        return this;
    }

    /**
     * @return true if the state of this object has been read, false otherwise.
     */
    public boolean isRead() {
        return isRead;
    }

    /**
     * Reads the state if it has not already been read, given by isRead(). Does nothing if isRead returns true.
     */
    public void readState() {
        if (!isRead()) {
            readStateImpl();
            isRead = true;
        }
    }

    public boolean hasFields() {
        return false;
    }

    public Stream<Map.Entry<Field, AbstractObjectState>> stream() {
        return ImmutableSet.<Map.Entry<Field, AbstractObjectState>>of().stream();
    }

//        public Iterator<ObjectStateI> objectStateIterator() {
//            return spliterator().
//        }

//        public Stream<ObjectStateI> stream() {return Iterables.any(this, x -> x.getValue().equals())}

    public String toStringRecursive() {
        final StringBuilder sb = new StringBuilder();
        toStringRecursiveImpl(sb, 1);
        return sb.toString();
    }

    protected void toStringRecursiveImpl(StringBuilder sb, int depth) {
        Function<Integer, String> indent = (tabs) -> StringUtils.repeat("\t", tabs);

        if (hasFields() && isRead()) {
            sb.append("{\n");
            stream().forEach(child -> {
                if (child.getKey() != null)
                    sb.append(indent.apply(depth) + child.getKey().getName() + "=");
                child.getValue().toStringRecursiveImpl(sb, depth + 1);
            });
            sb.append(indent.apply(depth - 1) + "}\n");
        } else {
            sb.append(toString() + "\n");
        }
    }

    protected Object getValue() {
        return value;
    }

    public Class<?> getType() {
        return value.getClass();
    }

    public void readState(int depth) {
        if (depth == 0) {
            return;
        }
        readState();
        stream().forEach(x -> x.getValue().readState(depth - 1));
    }

    @Override
    public String toString() {
        if (!isRead()) {
            return "PENDING(" + Integer.toHexString(System.identityHashCode(getValue())) + ")";
        }
        return Integer.toHexString(System.identityHashCode(getValue()));
    }

    /**
     * Reads this ObjectState's state. This method won't be called if isRead() returns true.
     */
    protected abstract void readStateImpl();

    /**
     * FACTORY
     **/
    private static final List<Class<?>> baseTypes = Arrays.asList(String.class, Integer.class, Double.class, Long.class, Character.class);

    /**
     * @param caller
     * @param type   Type of the value parameter. It's required because null values don't have type information.
     * @param value
     * @return
     */
    public AbstractObjectState createObjectState(AbstractObjectState caller, Class<?> type, Object value) {
        if (value == null) {
            return new NullState(caller, type);
        }
        if (baseTypes.stream().anyMatch(x -> x.equals(value.getClass()))) {
            // CREATE BASETYPE
            return new BaseTypeState(value, caller);
        } else if (value.getClass().isArray()) {
            // CREATE ARRAYTYPE
            return new ArrayObjectState(value, caller);
        } else {
            Optional<AbstractObjectState> reference = find(value);
            if (reference.isPresent() && reference.get() instanceof ObjectState) {
                return new ObjectStateReference(caller, (ObjectState) reference.get());
            }
            return new ObjectState(value, caller);
        }
    }

//        abstract public void refresh(); // maybe? I'm pretty sure it has to be done through the parent because:
    // this might be a basetype, which is not a reference to the original value
    // this might be a nulltype, which is not a reference to the original value

    // abstract public boolean isExpanded();
}
