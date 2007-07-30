package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.DummyFieldSuffix;
import au.net.netstorm.boost.test.field.FieldSuffix;

public final class DummyMatcher implements Matcher {
    private final FieldSuffix suffix = new DummyFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
