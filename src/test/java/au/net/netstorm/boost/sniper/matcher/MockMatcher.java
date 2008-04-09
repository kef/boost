package au.net.netstorm.boost.sniper.matcher;

import au.net.netstorm.boost.sniper.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.sniper.field.BoostField;
import au.net.netstorm.boost.sniper.field.FieldSuffix;
import au.net.netstorm.boost.sniper.field.MockFieldSuffix;

public final class MockMatcher implements Matcher {
    private final FieldSuffix suffix = new MockFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
