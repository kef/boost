package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorField extends Primordial implements CreatorField {
    private Interface creatorInterface;
    private String fieldName;

    public DefaultCreatorField(Interface creatorInterface, String fieldName) {
        this.creatorInterface = creatorInterface;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getCreatorInterface() {
        return creatorInterface;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (creatorInterface == null)
            throw new IllegalArgumentException();
        if (fieldName == null)
            throw new IllegalArgumentException();
    }
}
