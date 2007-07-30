package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.util.type.Data;

public final class RandomMatcher implements Matcher {

    public boolean matches(BoostField field) {
        return !isNonDataInterface(field);
    }

    private boolean isNonDataInterface(BoostField field) {
        if (!field.isInterface()) return false;
        return !Data.class.isAssignableFrom(field.getType());
    }
}
