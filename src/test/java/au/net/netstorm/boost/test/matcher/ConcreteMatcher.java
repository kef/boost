package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.random.ConcreteRandomProvider;
import au.net.netstorm.boost.test.random.RandomProvider;

public final class ConcreteMatcher implements Matcher {

    Matcher common = new CommonMatcher();
    RandomProvider provider = new ConcreteRandomProvider();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return provider.canProvide(field.getType());
    }
}
