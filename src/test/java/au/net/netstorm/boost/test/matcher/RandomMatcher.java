package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.util.type.Data;

public final class RandomMatcher implements Matcher {
    private final Matcher common = new InjectableMatcher();
    private final Matcher mock = new MockMatcher();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        if (mock.matches(field)) return false;
        if (isNonDataInterface(field)) return false;
        return true;
    }

    private boolean isNonDataInterface(BoostField field) {
        if (!field.isInterface()) return false;
        return !Data.class.isAssignableFrom(field.getType());
    }
}
