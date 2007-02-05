package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 1665 Interface.
public final class DefaultCreatorField extends Primordial implements Data {
    private Class creatorType;
    private Class instanceType;
    private String fieldName;

    public DefaultCreatorField(Class creatorType, Class instanceType, String fieldName) {
        this.creatorType = creatorType;
        this.instanceType = instanceType;
        this.fieldName = fieldName;
        validate();
    }

    public Class getCreatorType() {
        return creatorType;
    }

    public Class getInstanceType() {
        return instanceType;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (creatorType == null) throw new IllegalArgumentException();
        if (instanceType == null) throw new IllegalArgumentException();
        if (fieldName == null) throw new IllegalArgumentException();
    }
}
