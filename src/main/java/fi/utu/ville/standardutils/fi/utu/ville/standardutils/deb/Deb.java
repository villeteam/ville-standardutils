package fi.utu.ville.standardutils.fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.Iterables;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Ali Leino on 28.6.2015.
 */
public class Deb {

    public static void main(String[] args) {
        TestA a = new TestA();
//        parse(a);
        ObjectState s = new ObjectState(a);
        s.readState(5);
        System.out.println(s.toString());
//        s.readState();

    }

    public static void parse(Object input) {
        Class<?> type = input.getClass();
        ObjectState state = new ObjectState(input);
    }

    static class ObjectStateReference {
        private ObjectState reference;
        public ObjectStateReference(ObjectState reference) {
            this.reference = reference;
        }
    }

    static class ObjectState {
        // What if objectStates are of multiple different types lke valuetype, classType, referenceType?
        private static final List<Class<?>> baseTypes = Arrays.asList(String.class, Integer.class, Double.class, Long.class, Character.class);
        private static final int MAX_RECURSION = 5;
        private static final Object NULL = new String("null");

        abstract static class ObjectReference {
            /**
             * Idea: This encapsulates the value of the objectstate. Value is either: actual value, or ObjectState reference.
             * abstract method: toStringImpl(StringSettings)
             *          - ObjectState references print reference info (or if settings specify, print the actual state)
             *          - Object if this is a basetype
             *          - Nullstuff if this is null
             */

            private ObjectReference() {

            }

            abstract public boolean isExpanded();

        }

        static class BaseTypeReference extends ObjectReference{
            Object value;
            public BaseTypeReference(Object value) {
                super();
                this.value = value;
            }

            @Override
            public boolean isExpanded() { return true; }
        }

        static class NodeObjectReference {
            Object value;

            public NodeObjectReference(Object value) {
                this.value = value;
            }

        }

        static class LinkedObjectReference {
            ObjectState value;

            public LinkedObjectReference(ObjectState value) {
                this.value = value;
            }
        }

        final Class<?> type;

        private HashMap<Field, ObjectState> fields;
        private boolean isExpanded = false;
        private Object value; // might not be smart to store these always, might be an option to do for only leaves / primitive types?
                              // this might sometimes be set to a placeholder object which only tells the type it is supposed to refer to and its former address?
        private final ObjectState parent;
        private final boolean isBaseType;

        private ObjectState(Object input) {
            this(input, null);
        }

        private ObjectState(Object input, ObjectState parent) {
            this.type = input != null ? input.getClass() : NULL.getClass();
            this.value = input != null ? input : NULL;
            isBaseType = baseTypes.stream().anyMatch(x ->x.equals(type));
            this.parent = parent;
        }

        public Object getValue() {
            return value;
        }
        protected void refresh(ObjectState child) {

        }

//        private static final Stream<Class<?>> baseTypes = Arrays.stream(new Class<?> []
//                {String.class, Integer.class, Double.class, Long.class, Character.class});

        public void readState() {
            if(isBaseType) {
                return; // nothing to read
            }
            // Note: getDeclaredFields ignores inherited fields, get them with getFields
            fields = new HashMap<>();
            for(Field field : type.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(value);

//                    System.out.println(field + " " + field.getName() + "=" + fieldValue.toString());
                    ObjectState st = find(fieldValue);
                    if(st == null) {
                        st = new ObjectState(fieldValue);
                    }
                    fields.put(field, st);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            isExpanded = true;
        }

        private ObjectState find(Object fieldValue) {
            Optional<ObjectState> result = fields.values().stream().filter(x -> x.isExpanded && x.getValue().equals(fieldValue)).findAny();
            if(result.isPresent()) {
                return result.get();
            }
            else if(parent != null) {
                return parent.find(fieldValue);
            }
            return null;
        }

        public void readState(int depth) {
            readState();
            if(depth > 0)
            if(!isBaseType)
                fields.values().forEach(y -> y.readState(depth-1));
        }

        public HashMap<Field, ObjectState> getFields() {
            return fields;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            toStringImpl(sb, 1);
            return sb.toString();
        }

        private void toStringImpl(StringBuilder sb, int depth) {
            if(this.isBaseType) {
                sb.append(value.toString() + "\n");
                return;
            }
            sb.append("{\n");

            Function<Integer, String> indent = (tabs) -> StringUtils.repeat("\t", tabs);
            if(this.isExpanded) {
                getAllFields().forEach(x -> {
                    sb.append(indent.apply(depth));
                    sb.append(x.getKey().getName()+ "=");
                    x.getValue().toStringImpl(sb, depth + 1);

                });
            }
            sb.append(indent.apply(depth-1) + "}\n");

        }

        public Iterable<Map.Entry<Field, ObjectState>> getAllFields() {
            return Iterables.concat(fields.entrySet());
        }

        public boolean hasParent() {
            return parent != null;
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