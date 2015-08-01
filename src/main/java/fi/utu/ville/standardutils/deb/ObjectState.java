package fi.utu.ville.standardutils.deb;

import com.google.gwt.i18n.server.testing.Child;
import com.google.gwt.thirdparty.guava.common.collect.Iterables;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Phatency on 23.7.2015.
 */
public class ObjectState extends AbstractObjectState {
    private ArrayList<ChildReference> fields = new ArrayList<>();

    // TODO: protected
//    public ObjectState(Object input) {
//        this(input, null);
//    }

    protected ObjectState(ObjectStateFactory factory, Object value, AbstractObjectState parent) {
        super(factory, value, parent);

    }

    @Override
    protected void readStateImpl() {
        // Note: getDeclaredFields ignores inherited fields, get them with getFields
        if(fields.size() > 0) {
            System.out.println("Throwing away : " + fields);
            fields.clear();
        }
        for (Field field : getType().getDeclaredFields()) {
            try {

                field.setAccessible(true);
                Object fieldValue = field.get(getValue());
                AbstractObjectState st = getFactory().create(this, field, fieldValue);

                fields.add(new ChildReference(st, field));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

//    public Iterable<Map.Entry<Field, AbstractObjectState>> getAllFields() {
//        return Iterables.concat(fields.entrySet());
//    }

    @Override
    public Stream<ChildReference> stream() {
        return fields.stream();
    }

}
