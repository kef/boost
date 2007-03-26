package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class DummyArrayMatcher implements Matcher {
    // FIX 1676 Do it.
    public boolean matches(BoostField field) {
        if (field.isStatic()) return false;
        if (field.isFinal()) return false;
        if (!field.isArray()) return false;
        return field.isNull();
    }
}
