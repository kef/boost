package au.net.netstorm.boost.pebble.inject.newer.field;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerField extends Primordial implements NewerField {
    private Interface newerInterface;
    private Implementation instanceImplementation;
    private String fieldName;

    public DefaultNewerField(Interface newerInterface, Implementation instanceImplementation, String fieldName) {
        this.newerInterface = newerInterface;
        this.instanceImplementation = instanceImplementation;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getNewerInterface() {
        return newerInterface;
    }

    public Implementation getInstanceImplementation() {
        return instanceImplementation;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (newerInterface == null) throw new IllegalArgumentException();
        if (instanceImplementation == null) throw new IllegalArgumentException();
        if (fieldName == null) throw new IllegalArgumentException();
    }
}
