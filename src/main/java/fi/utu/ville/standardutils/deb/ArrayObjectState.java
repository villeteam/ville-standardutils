package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.Maps;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Phatency on 23.7.2015.
 */
public class ArrayObjectState extends AbstractObjectState {

    private ArrayList<AbstractObjectState> content = new ArrayList<>();
    private Class<?> componentType;

    public ArrayObjectState(Object value, AbstractObjectState parent) {
        super(value, parent);
        this.componentType = getType().getComponentType();
    }

    @Override
    public boolean hasFields() {
        return true;
    }

    @Override
    public Stream<Map.Entry<Field, AbstractObjectState>> stream() {
        return content.stream().map(x -> Maps.immutableEntry((Field) null, x));
    }

    @Override
    protected void readStateImpl() {
        int length = Array.getLength(getValue());
        for (int i = 0; i < length; i++) {
            Object element = Array.get(getValue(), i);

            AbstractObjectState st = createObjectState(this, componentType, element);
            content.add(st);
        }
    }

//        @Override
//        protected void toStringRecursiveImpl(StringBuilder sb, int depth) {
////            for(AbstractObjectState element : content) {
////                sb.append()
////            }
////            sb.append((isRead() ? toString() : super.toString()) + "\n");
//        }

//        @Override
//        public String toString() {
//            return "[" + content.stream()
//                    .map(x -> x.toStringRe())
//                    .collect(Collectors.joining(", ")) + "]";
////            StringJoiner sj = new StringJoiner(",", "[", "]");
////            for(Object element : content) {
////                sj.add(element.toString());
////            }
////            return sj.toString();
//        }
}
