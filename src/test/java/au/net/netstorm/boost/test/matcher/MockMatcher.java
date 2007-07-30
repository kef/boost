package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.FieldSuffix;
import au.net.netstorm.boost.test.field.MockFieldSuffix;

public final class MockMatcher implements Matcher {
    private final FieldSuffix suffix = new MockFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
