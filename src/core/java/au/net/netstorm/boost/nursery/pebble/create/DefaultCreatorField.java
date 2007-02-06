package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorField extends Primordial implements CreatorField {
    private Interface creatorType;
    private String fieldName;

    // FIX BREADCRUMB 1665 An interface.
    public DefaultCreatorField(Interface creatorType, String fieldName) {
        this.creatorType = creatorType;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getCreatorType() {
        return creatorType;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (creatorType == null)
            throw new IllegalArgumentException();
        if (fieldName == null)
            throw new IllegalArgumentException();
    }
}
