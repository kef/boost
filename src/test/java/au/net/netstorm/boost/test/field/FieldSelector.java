package au.net.netstorm.boost.test.field;

import au.net.netstorm.boost.test.matcher.Matcher;

public interface FieldSelector {
    BoostField[] select(BoostField[] fields, Matcher matcher);
}
