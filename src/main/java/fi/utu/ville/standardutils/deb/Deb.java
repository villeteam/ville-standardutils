package fi.utu.ville.standardutils.deb;

import java.lang.reflect.Field;
import java.util.*;
// TODO: after refreshing, a null reference may turn out to be a classState, baseType,

/**
 * A temporary testing class
 */
public class Deb {

    public static void main(String[] args) {
        TestA a = new TestA();
//        parse(a);
        ObjectStateFactory f = new ObjectStateFactory();
        AbstractObjectState s =  f.createRoot(a);
        s.readState(3);
        System.out.println(s.toStringRecursive());
        s.readState();
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

/**
 * A temporary testing class
 */
class TestA {
    private static int i = 0;
    private int a;
    private TestA b;
    private TestA parent;
    private TestA[] c;
    private ArrayList<TestA> arr;
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
            c = new TestA[]{new TestA(b)};
            arr = new ArrayList<>();
            arr.add(b);
        }
    }
    public void inc() { a = a +1; }

}