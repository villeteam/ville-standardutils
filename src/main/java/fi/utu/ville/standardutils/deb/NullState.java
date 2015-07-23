package fi.utu.ville.standardutils.deb;

import org.apache.commons.lang3.ObjectUtils;

/**
 * Created by Phatency on 23.7.2015.
 */
public class NullState extends AbstractObjectState {
    private final Class<?> type;

    public NullState(AbstractObjectState parent, Class<?> type) {
        super(ObjectUtils.NULL, parent);
        this.type = type;
    }

    @Override
    protected void readStateImpl() {
    }

    @Override
    public Class<?> getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "null";
    }
}
