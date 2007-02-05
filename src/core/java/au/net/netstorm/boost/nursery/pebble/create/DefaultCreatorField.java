package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 1665 Interface.
public final class DefaultCreatorField extends Primordial implements Data, CreatorField {
    private Class creatorType;
    private String fieldName;

    public DefaultCreatorField(Class creatorType, String fieldName) {
        this.creatorType = creatorType;
        this.fieldName = fieldName;
        validate();
    }

    public Class getCreatorType() {
        return creatorType;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (creatorType == null) throw new IllegalArgumentException();
        if (fieldName == null) throw new IllegalArgumentException();
    }
}
