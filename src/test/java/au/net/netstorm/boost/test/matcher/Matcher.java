package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;

// SUGGEST: Rename to FieldMatcher
public interface Matcher {
    boolean matches(BoostField field);
}
