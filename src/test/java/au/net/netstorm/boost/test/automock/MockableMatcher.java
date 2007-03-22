package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class MockableMatcher implements Matcher {
    public boolean matches(BoostField field) {
        if (field.isFinal()) return false;
        return field.isInterface();
    }
}
