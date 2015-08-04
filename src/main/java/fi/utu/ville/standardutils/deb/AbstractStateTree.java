package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableSet;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * Created by Phatency on 4.8.2015.
 */
public abstract class AbstractStateTree<T extends AbstractStateTree, U> {
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
