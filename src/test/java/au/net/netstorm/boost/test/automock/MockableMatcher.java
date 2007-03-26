package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

// OK CyclomaticComplexity|ReturnCount {
public final class MockableMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isInterface();
    }
}
// } OK CyclomaticComplexity|ReturnCount
