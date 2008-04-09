package au.net.netstorm.boost.sniper.matcher;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.sniper.field.BoostField;

public final class RandomMatcher implements Matcher {
    public boolean matches(BoostField field) {
        return !isNonDataInterface(field);
    }

    private boolean isNonDataInterface(BoostField field) {
        if (!field.isInterface()) return false;
        return !Data.class.isAssignableFrom(field.getType());
    }
}
