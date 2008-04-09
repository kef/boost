package au.net.netstorm.boost.sniper.matcher;

import au.net.netstorm.boost.sniper.field.BoostField;

// SUGGEST: Rename to FieldMatcher
public interface Matcher {
    boolean matches(BoostField field);
}
