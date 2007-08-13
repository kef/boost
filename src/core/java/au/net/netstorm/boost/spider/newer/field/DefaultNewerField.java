package au.net.netstorm.boost.spider.newer.field;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerField extends Primordial implements NewerField {
    private Interface newerInterface;
    private Implementation classToNu;
    private String fieldName;

    public DefaultNewerField(Interface newerInterface, Implementation classToNu, String fieldName) {
        this.newerInterface = newerInterface;
        this.classToNu = classToNu;
        this.fieldName = fieldName;
        validate();
    }

    public Interface getNewerInterface() {
        return newerInterface;
    }

    public Implementation getClassToNu() {
        return classToNu;
    }

    public String getFieldName() {
        return fieldName;
    }

    private void validate() {
        if (newerInterface == null) throw new IllegalArgumentException();
        if (classToNu == null) throw new IllegalArgumentException();
        if (fieldName == null) throw new IllegalArgumentException();
    }
}
