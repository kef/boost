package au.net.netstorm.boost.gunge.matcher;

import au.net.netstorm.boost.gunge.automock.FieldSuffixMatcher;
import au.net.netstorm.boost.gunge.field.BoostField;
import au.net.netstorm.boost.gunge.field.DummyFieldSuffix;
import au.net.netstorm.boost.gunge.field.FieldSuffix;

public final class DummyMatcher implements Matcher {
    private final FieldSuffix suffix = new DummyFieldSuffix();
    private final Matcher matcher = new FieldSuffixMatcher(suffix);

    public boolean matches(BoostField field) {
        return matcher.matches(field);
    }
}
