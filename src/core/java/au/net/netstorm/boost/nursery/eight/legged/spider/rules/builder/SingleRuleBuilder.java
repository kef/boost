package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.BuildableWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class SingleRuleBuilder implements RuleBuilder, RulePattern {
    public SingleRuleBuilder(BuildableWeb web) {
    }

    public RulePattern type(Class<?> type) {
        /// FIX 2394 build state
        return this;
    }

    public RulePattern pattern(Class<?> host, Class<?> type, String name) {
        /// FIX 2394 build state
        return this;
    }

    public RulePattern pattern(InjectionPattern pattern) {
        /// FIX 2394 build state
        return this;
    }

    public void toFactory(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public void to(Object instance) {
        throw new UnsupportedOperationException();
    }

    public void to(Class<?> impl) {
        throw new UnsupportedOperationException();
    }
}
