package au.net.netstorm.boost.sniper.field;

import au.net.netstorm.boost.sniper.matcher.Matcher;

public interface FieldSelector {
    BoostField[] select(BoostField[] fields, Matcher matcher);
}
