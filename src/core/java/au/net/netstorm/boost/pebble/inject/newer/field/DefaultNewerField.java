package au.net.netstorm.boost.pebble.inject.newer.field;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerField extends Primordial implements NewerField {
    private Interface newerInterface;
    private Class instanceImplementation;
    private String fieldName;

    public DefaultNewerField(Interface newerInterface, Class instanceImplementation, String fieldName) {
        this.newerInterface = newerInterface;
        this.instanceImplementation = instanceImplementation;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getNewerInterface() {
        return newerInterface;
    }

    public Class getInstanceImplementation() {
        return instanceImplementation;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (newerInterface == null)
            throw new IllegalArgumentException();
        if (instanceImplementation == null)
            throw new IllegalArgumentException();
        if (fieldName == null)
            throw new IllegalArgumentException();
    }
}
