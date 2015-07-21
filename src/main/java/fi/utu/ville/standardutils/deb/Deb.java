package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.Iterables;
import com.google.gwt.thirdparty.guava.common.collect.Iterators;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
// TODO: after refreshing, a null reference may turn out to be a classState, baseType,
/**
 * Created by Ali Leino on 28.6.2015.
 */
public class Deb {

    public static void main(String[] args) {
        TestA a = new TestA();
//        parse(a);
        ObjectState s = new ObjectState(a);
        s.readState(2);
        System.out.println(s.toStringRecursive());
//        s.readState();

    }

    static class ObjectStateReference extends ObjectStateI {
        private ObjectState reference;
        public ObjectStateReference(ObjectStateI parent, ObjectState reference) {
            super(reference.getValue(), parent);
            this.reference = reference;
        }

        @Override
        public boolean isRead() {
            return reference.isRead();
        }

        @Override
        protected void readStateImpl() {
            reference.readStateImpl();
        }

        @Override
        public String toString() {
            return "REF";
        }
    }

    // TODO: Generate an easy-to-read ID for all objectstates while reading the tree.
    static public abstract class ObjectStateI implements Iterable<Map.Entry<Field, ObjectStateI>> {
        private final ObjectStateI parent;
        private Object value; // TODO: it may not be a good idea to hold references to all objects
        // might not be smart to store these always, might be an option to do for only leaves / primitive types?
        // this might sometimes be set to a placeholder object which only tells the type it is supposed to refer to and its former address?
        private boolean isRead;

        public ObjectStateI(Object value, ObjectStateI parent) {
            this.value = value;
            this.parent = parent;
        }

        public ObjectStateI(Object value) {
            this(value, null); // no parent
        }

        public ObjectStateI getParent() {
            return parent;
        }

        public boolean hasParent() {
            return parent != null;
        }

        /**
         * Performs DFS on the root node of this tree.
         * @param value
         * @return
         */
        public Optional<ObjectStateI> find(Object value) {
            ObjectStateI root = getRoot();
            return root.findImpl(value);
        }

        protected Optional<ObjectStateI> findImpl(Object value) {
            if(this.getValue().equals(value)) {
                return Optional.of(this);
            }
            return stream()
                    .map(x->x.getValue().findImpl(value))
                    .filter(x -> x.isPresent())
                    .findAny()
                    .orElse(Optional.empty());
        }

        // TODO: No recursion for no reason
        public ObjectStateI getRoot() {
            if(hasParent()) {
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
            if(!isRead()) {
                readStateImpl();
                isRead = true;
            }
        }

        public boolean hasFields() {
            return false;
        }

        @Override
        public Iterator<Map.Entry<Field, ObjectStateI>> iterator() {
            return Iterators.emptyIterator();
        }

        public Stream<Map.Entry<Field,ObjectStateI>> stream() { return Stream.empty();}

//        public Iterator<ObjectStateI> objectStateIterator() {
//            return spliterator().
//        }

//        public Stream<ObjectStateI> stream() {return Iterables.any(this, x -> x.getValue().equals())}

        public String toStringRecursive() {
            final StringBuilder sb = new StringBuilder();
            toStringRecursiveImpl(sb, 1);
            return sb.toString();
        }

        private void toStringRecursiveImpl(StringBuilder sb, int depth) {
            Function<Integer, String> indent = (tabs) -> StringUtils.repeat("\t", tabs);

            if(hasFields() && isRead()) {
                sb.append("{\n");
                for(Map.Entry<Field, ObjectStateI> field : this) {
                    sb.append(indent.apply(depth) + field.getKey().getName() + "=");
                    if(field.getValue().hasFields()) {
                        field.getValue().toStringRecursiveImpl(sb, depth+1);
                    }
                    else {
                        sb.append(field.getValue() + "\n");
                    }
                }
                sb.append(indent.apply(depth-1) + "}\n");
            }
            else {
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
            if(depth ==0) {
                return;
            }
            readState();
            stream().map(x-> x.getValue()).forEach(x -> x.readState(depth-1));
        }

        /**
         * Reads this ObjectState's state. This method won't be called if isRead() returns true.
         */
        protected abstract void readStateImpl();

        /** FACTORY **/
        private static final List<Class<?>> baseTypes = Arrays.asList(String.class, Integer.class, Double.class, Long.class, Character.class);

        public ObjectStateI createObjectState(ObjectStateI caller, Field field, Object value) {
            if(value == null) {
                return new NullState(caller, field.getType());
            }
            if(baseTypes.stream().anyMatch(x ->x.equals(value.getClass()))) {
                // CREATE BASETYPE
                return new BaseTypeState(value,caller);
            }
            else if(value.getClass().isArray()) {
                // CREATE ARRAYTYPE
                return new ObjectState(value,caller);
            }
            else {
                Optional<ObjectStateI> reference = find(value);
                if(reference.isPresent() && reference.get() instanceof ObjectState) {
                    return new ObjectStateReference(caller, (ObjectState)reference.get());
                }
                return new ObjectState(value, caller);
            }
        }

//        abstract public void refresh(); // maybe? I'm pretty sure it has to be done through the parent because:
                                          // this might be a basetype, which is not a reference to the original value
                                          // this might be a nulltype, which is not a reference to the original value

        // abstract public boolean isExpanded();
    }

    static public class BaseTypeState extends ObjectStateI {

        public BaseTypeState(Object value, ObjectStateI parent) {
            super(value, parent);
        }

        @Override
        protected void readStateImpl() { } // Basetypes don't have children, getValue is sufficient.

        @Override
        public String toString() {
            return getValue().toString();
        }
    }

    static public class NullState extends ObjectStateI {
        private final Class<?> type;

        public NullState(ObjectStateI parent, Class<?> type) {
            super(ObjectUtils.NULL, parent);
            this.type = type;
        }

        @Override
        protected void readStateImpl() {}

        @Override
        public Class<?> getType() {
            return this.type;
        }

        @Override
        public String toString() { return "null";}
    }

    static class ObjectState extends ObjectStateI {
        private HashMap<Field, ObjectStateI> fields = new HashMap<>();

        private ObjectState(Object input) {
            this(input, null);
        }

        private ObjectState(Object value, ObjectStateI parent) {
            super(value, parent);

        }

        @Override
        protected void readStateImpl() {
            // Note: getDeclaredFields ignores inherited fields, get them with getFields
            fields = new HashMap<>();
            for(Field field : getType().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(getValue());

//                    System.out.println(field + " " + field.getName() + "=" + fieldValue.toString());
                    ObjectStateI st = createObjectState(this, field, fieldValue);
                    fields.put(field, st);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            if(!isRead()) {
                return "unknown(" + Integer.toHexString(System.identityHashCode(getValue())) + ")";
            }
            return toStringRecursive();
        }

//        public ObjectState find(Object fieldValue) {
//            Optional<ObjectState> result = fields.values().stream().filter(x -> x.isRead() && x.getValue().equals(fieldValue)).findAny();
//            if(result.isPresent()) {
//                return result.get();
//            }
//            else if(hasParent()) {
//                //return getParent().find(fieldValue);
//                // TODO: reimplement
//                return null;
//            }
//            return null;
//        }

        public HashMap<Field, ObjectStateI> getFields() {
            return fields;
        }

        public Iterable<Map.Entry<Field, ObjectStateI>> getAllFields() {
            return Iterables.concat(fields.entrySet());
        }

        @Override
        public Iterator<Map.Entry<Field, ObjectStateI>> iterator() {
            return fields.entrySet().iterator();
        }

        @Override
        public boolean hasFields() {
            return true;
        }

        @Override
        public Stream<Map.Entry<Field, ObjectStateI>> stream() {
            return fields.entrySet().stream();
        }
    }

    static class StateDiff {
        final ObjectState prevState, newState; // don't know if these are needed after initialization
        ArrayList<Field> diffFields = new ArrayList<>();
        public StateDiff(ObjectState prevState, ObjectState newState) { // make sure they are of the same type
            this.prevState = prevState;
            this.newState = newState;
            diff();
        }

        private void diff() {
//            for(Map.Entry<Field, Object> oldField : prevState.getFields().entrySet()) {
//                Object newValue = newState.getFields().get(oldField.getKey());
//                if (!Objects.equals(oldField.getValue(), newValue)) {
//                    diffFields.add(oldField.getKey());
//                }
//
//            }
        }
    }
}

class TestA {
    private static int i = 0;
    private int a;
    private TestA b;
    private TestA parent;
    public TestA() {
        this(null);
    }
    public TestA(TestA parent) {
        a = i;
        i++;
        this.parent = parent;
        Random rand = new Random();
        if(rand.nextBoolean()) {
            b = new TestA(this);
        }
    }
    public void inc() { a = a +1; }

}