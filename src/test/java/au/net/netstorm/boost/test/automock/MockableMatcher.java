package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

// FIX 1676 Exlude dummies?
public final class MockableMatcher implements Matcher {
    public boolean matches(BoostField field) {
        if (!field.isInterface()) return false;
        if (field.isStatic()) return false;
        return field.isNull();
    }
}
