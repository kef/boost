package au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.multiplicity.Multiplicity;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.BuildableWeb;

// FIX 2394 should be SingleRuleBuilder and MultiRuleBuilder
public final class DefaultRuleBuilder implements RuleBuilder {
    public DefaultRuleBuilder(BuildableWeb web, Multiplicity multiplicity) {
    }

    public RulePattern type(Class<?> type) {
        throw new UnsupportedOperationException();
    }

    public RulePattern pattern(Class<?> host, Class<?> type, String name) {
        throw new UnsupportedOperationException();
    }

    public RulePattern pattern(InjectionPattern pattern) {
        throw new UnsupportedOperationException();
    }
}
