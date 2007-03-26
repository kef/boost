package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class DummyMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        if (field.isInterface()) return false;
        return !field.isArray();
    }
}
