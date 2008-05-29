package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class MockRule implements Rule {
    private final InjectionType expected;

    public MockRule(InjectionType expected) {
        this.expected = expected;
    }

    public Factory getFactory() {
        throw new UnsupportedOperationException();
    }

    public boolean accepts(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof KeyedRule)) return false;
        KeyedRule rule = (KeyedRule) o;
        InjectionType actual = rule.key();
        return expected.equals(actual);
    }
}
