package fi.utu.ville.standardutils.deb;

import javax.lang.model.type.NullType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Phatency on 24.7.2015.
 */
public class ObjectStateFactory {

    // TODO: ability to add more basetypes (which would not technically be "base types" per se, but classes which would
    // always be leaf-nodes.

    private static final List<Class<?>> baseTypes = Arrays.asList(String.class, Integer.class, Double.class, Long.class, Character.class);
    private static final List<Class<?>> collectionTypes = Arrays.asList(Collection.class);
    private final HashMap<AbstractObjectState, Integer> ids = new HashMap<>();
    private AbstractObjectState root;
    private int nextId = 0;

    public ObjectStateFactory() {
    }

    /**
     * @param parent
     * @param type   Type of the value parameter. It's required because null values don't carry type information.
     * @param value
     * @return
     */
    public AbstractObjectState create(AbstractObjectState parent, Class<?> type, Object value, Type genericType) {
        if(type == null) {
            throw new NullPointerException();
        }
        AbstractObjectState state;
        if (value == null) {
            state = new NullState(this, parent, type);
        } else if (baseTypes.stream().anyMatch(x -> x.equals(value.getClass()))) {
            // CREATE BASETYPE
            state = new BaseTypeState(this, value, parent);
        } else if (value.getClass().isArray() ||
                collectionTypes
                        .stream()
                        .anyMatch(x -> x.isAssignableFrom(type))) {
            // CREATE ARRAYTYPE
            state = new ArrayObjectState(this, value, parent, inferTypeParameters(genericType));
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
        ids.put(state, nextId++);
        System.out.println("" + (nextId-1) + " created " + state.toString() + ":" + type.getName() +  " parent: " + (parent != null ? parent.getId(): -1));
        return state;
    }


    public AbstractObjectState create(AbstractObjectState parent, Class<?> type, Object value) {
        return create(parent,type,value,null);
    }

    public AbstractObjectState create(AbstractObjectState parent, Field field, Object value) {
        return create(parent, field.getType(), value, field.getGenericType());
    }

    /**
     * Returns the generic type parameters in param or if none found (possibly due to type erasure), returns an array
     * with single Object.class type. This conforms to Java's normal generic type returning methods when the type
     * information has been erased.
     * @param genericType
     * @return An array with generic type parameter(s), array.length > 0.
     */
    public static Class<?>[] inferTypeParameters(Type genericType) {
        String typeString = genericType.getTypeName();
        int beginIndex = typeString.indexOf('<');
        int endIndex = typeString.lastIndexOf('>');
        if(beginIndex == -1 || endIndex == -1) {
            return new Class<?>[] {Object.class};
        }
        String genericParams = typeString.substring(beginIndex+1, endIndex);
        if(genericParams.contains("<")) {
            // TODO: support for nested type parameters
            return new Class<?>[] { Object.class}; // We don't support nested typeParameters
        }
        String[] splitParams = genericParams.split(",");
        Class<?>[] typeParams = new Class<?>[splitParams.length];
        for(int i = 0; i < splitParams.length; ++i) {
            try {
                typeParams[i] = Class.forName(splitParams[i]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return typeParams;
    }


    public AbstractObjectState createRoot(Object value) {
        // If the user for some reason wants the root node to be null, we'll accept their decision, but have
        // no type information
        Class<?> type = value != null ? value.getClass() : NullType.class;
        return create(null, type, value, null);
    }

    public int getId(AbstractObjectState state) {
        return ids.get(state);
    }

    public AbstractObjectState getRoot() {
        return root;
    }
}
