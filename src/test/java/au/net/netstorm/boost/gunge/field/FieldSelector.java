package au.net.netstorm.boost.gunge.field;

import au.net.netstorm.boost.gunge.matcher.Matcher;

public interface FieldSelector {
    BoostField[] select(BoostField[] fields, Matcher matcher);
}
