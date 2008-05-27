package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public final class DefaultRuleTarget implements ApplyableRuleTarget {
    public DefaultRuleTarget(Multiplicity multi, Class<?> type) {
        throw new UnsupportedOperationException();
    }

    public RuleScope to(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public RuleScope to(Provider provider) {
        throw new UnsupportedOperationException();
    }

    public RuleScope to(Object instance) {
        throw new UnsupportedOperationException();
    }

    public RuleScope to(Class<?> impl) {
        throw new UnsupportedOperationException();
    }

    public void apply() {
        throw new UnsupportedOperationException();
    }
}
