package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

abstract class AbstractStateTree<T extends AbstractStateTree, U> {
    private final T parent;
    private final U value;

    public AbstractStateTree(U value, T parent) {
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
        return children().count() > 0;
    }

    public Stream<T> children() {
        return ImmutableSet.<T>of().stream();
    }

    protected U getValue() {
        return value;
    }

    public Class<?> getType() {
        return value.getClass();
    }

    static class ChildReference {
        private final AbstractObjectState state;
        private final Field field;

        public ChildReference(AbstractObjectState state, Field field) {
            this.state = state;
            this.field = field;
        }

        public AbstractObjectState getState() {
            return state;
        }

        public Field getField() {
            return field;
        }

        public ChildReference(AbstractObjectState state) {
            this(state, null);
        }

        public boolean isField() {
            return field != null;
        }
    }
}

/**
 * Created by Phatency on 23.7.2015.
 */ // TODO: Generate an easy-to-read ID for all objectstates while reading the tree.
// Maybe there should exist an ObjectStateFactory of which all ObjectStates have a reference to?
// TODO: Support for collections?
public abstract class AbstractObjectState extends AbstractStateTree<AbstractObjectState, Object> {
    // might not be smart to store these always, might be an option to do for only leaves / primitive types?
    // this might sometimes be set to a placeholder object which only tells the type it is supposed to refer to and its former address?
    private boolean isRead;
    protected final ObjectStateFactory factory;

    public AbstractObjectState(ObjectStateFactory factory, Object value, AbstractObjectState parent) {
        super(value, parent);
        this.factory = factory;
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
        return children()
                .map(x -> x.findImpl(value))
                .filter(x -> x.isPresent())
                .findAny()
                .orElse(Optional.empty());
    }

    public Stream<ChildReference> stream() {
        return ImmutableSet.<ChildReference>of().stream();
    }

    @Override
    public Stream<AbstractObjectState> children() {
        return stream().map(x -> x.getState());
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
            isRead = true;
            readStateImpl();
        }
    }

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
                if (child.isField())
                    sb.append(indent.apply(depth) + child.getField().getName() + "(" + child.getState().getId() + ")=");
                child.getState().toStringRecursiveImpl(sb, depth + 1);
            });
            sb.append(indent.apply(depth - 1) + "}\n");
        } else {
            sb.append(toString() + "\n");
        }
    }

    public void readState(int depth) {
        if (depth == 0) {
            return;
        }
        readState();
        stream().forEach(x -> x.getState().readState(depth - 1));
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


}
