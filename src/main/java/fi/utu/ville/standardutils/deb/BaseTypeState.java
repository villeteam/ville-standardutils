package fi.utu.ville.standardutils.deb;

/**
 * Created by Phatency on 23.7.2015.
 */
public class BaseTypeState extends AbstractObjectState {

    public BaseTypeState(ObjectStateFactory factory, Object value, AbstractObjectState parent) {
        super(factory, value, parent);
    }

    @Override
    protected void readStateImpl() {
    } // Basetypes don't have children, getValue is sufficient.

    @Override
    public String toString() {
        return getValue().toString();
    }
}
