package au.net.netstorm.boost.gunge.matcher;

import au.net.netstorm.boost.gunge.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.gunge.field.BoostField;
import au.net.netstorm.boost.gunge.field.FieldSuffix;
import au.net.netstorm.boost.gunge.field.MockFieldSuffix;

public final class MockMatcher implements Matcher {
    private final FieldSuffix suffix = new MockFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
