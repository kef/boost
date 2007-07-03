package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

public final class DummyArrayMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isArray();
    }
}
