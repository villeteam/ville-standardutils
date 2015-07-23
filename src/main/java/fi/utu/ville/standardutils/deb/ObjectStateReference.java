package fi.utu.ville.standardutils.deb;

/**
 * Created by Phatency on 23.7.2015.
 */
class ObjectStateReference extends AbstractObjectState {
    private ObjectState reference;

    public ObjectStateReference(AbstractObjectState parent, ObjectState reference) {
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
        return "REF(" + super.toString() + ")";
    }
}
