package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.ApplyableRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.RulePattern;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.DefaultRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;

public final class MockApplyableRuleBuilder implements ApplyableRuleBuilder {
    public void apply() {
        throw new UnsupportedOperationException();
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

    public boolean equals(Object other) {
        return other instanceof DefaultRuleBuilder;
    }

    public int hashCode() { return 0; }
}
