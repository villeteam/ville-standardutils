package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

abstract class AbstractStateTree<T extends AbstractStateTree> {
    private final T parent;
    private final Object value;

    public AbstractStateTree(Object value, T parent) {
        this.parent = parent;
        this.value = value;
    }

    public T getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean hasChildren() {
        return stream().count() > 0;
    }

    public Stream<Map.Entry<Field, AbstractObjectState>> stream() {
        return ImmutableSet.<Map.Entry<Field, AbstractObjectState>>of().stream();
    }

    protected Object getValue() {
        return value;
    }

    public Class<?> getType() {
        return value.getClass();
    }
}

/**
 * Created by Phatency on 23.7.2015.
 */ // TODO: Generate an easy-to-read ID for all objectstates while reading the tree.
// Maybe there should exist an ObjectStateFactory of which all ObjectStates have a reference to?
// TODO: Support for collections?
public abstract class AbstractObjectState {
    private final AbstractObjectState parent;
    private final Object value; // TODO: it may not be a good idea to hold references to all objects
    // might not be smart to store these always, might be an option to do for only leaves / primitive types?
    // this might sometimes be set to a placeholder object which only tells the type it is supposed to refer to and its former address?
    private boolean isRead;
    protected final ObjectStateFactory factory;

    public AbstractObjectState(ObjectStateFactory factory, Object value, AbstractObjectState parent) {
        this.value = value;
        this.parent = parent;
        this.factory = factory;
    }

//    public AbstractObjectState(ObjectStateFactory factory, Object value) {
//        this(factory, value, null); // no parent
//    }

    public AbstractObjectState getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public int getId() {
        return factory.getId(this);
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

    protected ObjectStateFactory getFactory() {
        return factory;
    }

    public AbstractObjectState getRoot() {
        return factory.getRoot();
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

    public boolean hasChildren() {
        return stream().count() > 0;
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

        if (hasChildren() && isRead()) {
            sb.append("{\n");
            stream().forEach(child -> {
                if (child.getKey() != null)
                    sb.append(indent.apply(depth) + child.getKey().getName() + "(" + child.getValue().getId() + ")=");
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
        // Integer.toHexString(System.identityHashCode(getValue()))
        if (!isRead()) {
            return "PENDING(" + getId() + ")";
        }
        return "id(" + getId() + ")";
    }

    /**
     * Reads this ObjectState's state. This method won't be called if isRead() returns true.
     */
    protected abstract void readStateImpl();

    //        abstract public void refresh(); // maybe? I'm pretty sure it has to be done through the parent because:
    // this might be a basetype, which is not a reference to the original value
    // this might be a nulltype, which is not a reference to the original value

    // abstract public boolean isExpanded();
}
