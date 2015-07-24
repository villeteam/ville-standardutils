package fi.utu.ville.standardutils.deb;

import javax.lang.model.type.NullType;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Phatency on 24.7.2015.
 */
class ObjectStateFactory {

    private static final List<Class<?>> baseTypes = Arrays.asList(String.class, Integer.class, Double.class, Long.class, Character.class);
    private static final List<Class<?>> collectionTypes = Arrays.asList(Collection.class);
    private AbstractObjectState root;

    public ObjectStateFactory() {

    }

    /**
     * @param parent
     * @param type   Type of the value parameter. It's required because null values don't carry type information.
     * @param value
     * @return
     */
    public AbstractObjectState create(AbstractObjectState parent, Class<?> type, Object value) {
        AbstractObjectState state;
        if (value == null) {
            state = new NullState(this, parent, type);
        } else if (baseTypes.stream().anyMatch(x -> x.equals(value.getClass()))) {
            // CREATE BASETYPE
            state = new BaseTypeState(this, value, parent);
        } else if (value.getClass().isArray() ||
                collectionTypes.stream().anyMatch(x -> x.isAssignableFrom(type))) {
            // CREATE ARRAYTYPE
            state = new ArrayObjectState(this, value, parent);
        } else {
            Optional<AbstractObjectState> reference = root != null ? root.find(value) : Optional.empty();
            if (reference.isPresent() && reference.get() instanceof ObjectState) {
                state = new ObjectStateReference(this, parent, (ObjectState) reference.get());
            } else {
                state = new ObjectState(this, value, parent);
            }
        }
        if (root == null) {
            root = state;
        }
        return state;
    }

    public AbstractObjectState createRoot(Object value) {
        // If the user for some reason wants the root node to be null, we'll accept their decision, but have
        // no type information
        Class<?> type = value != null ? value.getClass() : NullType.class;
        return create(null, type, value);
    }

}
