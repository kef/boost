package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.Matcher;

public final class DummyArrayMatcher implements Matcher {
    private final Matcher common = new CommonMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return field.isArray();
    }
}
