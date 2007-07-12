package au.net.netstorm.boost.test.matcher;

import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.random.ConcreteRandomProvider;

public final class ConcreteMatcher implements Matcher {
    Matcher common = new CommonMatcher();
    Provider provider = new ConcreteRandomProvider();

    public boolean matches(BoostField field) {
        if (!common.matches(field)) return false;
        return provider.canProvide(field.getType());
    }
}
