package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Immutable;
import au.net.netstorm.boost.util.nullo.NullChecker;

// FIXME: SC506 Can just be an immutable.
public final class DefaultFieldSpec extends Primordial implements FieldSpec, Immutable {
    private final String fieldName;
    private final Class type;

    public DefaultFieldSpec(String fieldName, Class type) {
        this.fieldName = fieldName;
        this.type = type;
        noNulls();
    }

    public String getName() {
        return fieldName;
    }

    public Class getType() {
        return type;
    }

    private void noNulls() {
        NullChecker.check(fieldName);
        NullChecker.check(type);
    }
}
