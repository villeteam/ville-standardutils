package fi.utu.ville.standardutils.deb;

import com.google.gwt.i18n.server.testing.Child;
import com.google.gwt.thirdparty.guava.common.collect.Maps;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Phatency on 23.7.2015.
 */
public class ArrayObjectState extends AbstractObjectState {

    private ArrayList<ChildReference> content = new ArrayList<>();
    private Class<?> componentType;

    public ArrayObjectState(ObjectStateFactory factory, Object value, AbstractObjectState parent, Class<?>[] typeParams) {
        super(factory, value, parent);
        if(getType().isArray()) {
            this.componentType = getType().getComponentType();
        } else {
            componentType = typeParams[0];
        }
    }

    @Override
    public Stream<ChildReference> stream() {
        return content.stream();
    }

    @Override
    protected void readStateImpl() {
        if(content.size() > 0) {
            System.out.println("Throwing array away: ");
        }
        if(getType().isArray()) {
            int length = Array.getLength(getValue());
            for (int i = 0; i < length; i++) {
                Object element = Array.get(getValue(), i);

                AbstractObjectState st = getFactory().create(this, componentType, element);
                content.add(new ChildReference(st));
            }
        }
        else {
            Collection c = (Collection)getValue();
            for(Object element : c) {
                AbstractObjectState st = getFactory().create(this, componentType, element);
                content.add(new ChildReference(st));
            }
        }
    }

        @Override
        protected void toStringRecursiveImpl(StringBuilder sb, int depth) {
//            for(AbstractObjectState element : content) {
//                sb.append()
//            }
            sb.append((isRead() ?
                    "[" + content.stream()
                            .map(x -> x.getState().toStringRecursive())
                            .collect(Collectors.joining(", ")) + "]"
                    : super.toString()) + "\n");
        }

        @Override
        public String toString() {
            return "[" + content.stream()
                    .map(x -> x.toString())
                    .collect(Collectors.joining(", ")) + "]";
//            StringJoiner sj = new StringJoiner(",", "[", "]");
//            for(Object element : content) {
//                sj.add(element.toString());
//            }
//            return sj.toString();
        }
}
