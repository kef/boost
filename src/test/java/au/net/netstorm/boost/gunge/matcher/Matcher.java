package au.net.netstorm.boost.gunge.matcher;

import au.net.netstorm.boost.gunge.field.BoostField;

// SUGGEST: Rename to FieldMatcher
public interface Matcher {
    boolean matches(BoostField field);
}
