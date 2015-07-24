package fi.utu.ville.standardutils.deb;

import com.google.gwt.thirdparty.guava.common.collect.Iterables;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Phatency on 23.7.2015.
 */
public class ObjectState extends AbstractObjectState {
    private HashMap<Field, AbstractObjectState> fields = new HashMap<>();

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
        fields = new HashMap<>();
        for (Field field : getType().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(getValue());
//                    System.out.println(field + " " + field.getName() + "=" + fieldValue.toString());
                AbstractObjectState st = getFactory().create(this, field.getType(), fieldValue);

                fields.put(field, st);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Iterable<Map.Entry<Field, AbstractObjectState>> getAllFields() {
        return Iterables.concat(fields.entrySet());
    }

    @Override
    public boolean hasFields() {
        return true;
    }

    @Override
    public Stream<Map.Entry<Field, AbstractObjectState>> stream() {
        return fields.entrySet().stream();
    }

}
