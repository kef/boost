package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

public interface Matcher {
    boolean matches(BoostField field);
}
