package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class DummyMatcher implements Matcher {
    MockableMatcher mockMatcher = new MockableMatcher();

    public boolean matches(BoostField field) {
        if (mockMatcher.matches(field)) return false;
        // FIX BREADCRUMB 1676 Here I am.  Wish you were here.
//        if (poisonMatcher.matches(field)) return false;
        return true;
    }
}
