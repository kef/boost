package au.net.netstorm.boost.sniper.matcher;

import au.net.netstorm.boost.sniper.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.sniper.field.BoostField;
import au.net.netstorm.boost.sniper.field.DummyFieldSuffix;
import au.net.netstorm.boost.sniper.field.FieldSuffix;

public final class DummyMatcher implements Matcher {
    private final FieldSuffix suffix = new DummyFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
