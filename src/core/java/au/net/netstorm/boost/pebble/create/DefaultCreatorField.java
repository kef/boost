package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorField extends Primordial implements CreatorField {
    private Interface creatorInterface;
    private Class instanceImplementation;
    private String fieldName;

    public DefaultCreatorField(Interface creatorInterface, Class instanceImplementation, String fieldName) {
        this.creatorInterface = creatorInterface;
        this.instanceImplementation = instanceImplementation;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getCreatorInterface() {
        return creatorInterface;
    }

    public Class getInstanceImplementation() {
        return instanceImplementation;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (creatorInterface == null)
            throw new IllegalArgumentException();
        if (instanceImplementation == null)
            throw new IllegalArgumentException();
        if (fieldName == null)
            throw new IllegalArgumentException();
    }
}
