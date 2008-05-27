package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.ApplyableRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.RuleTarget;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.DefaultRuleBuilder;

public final class MockApplyableRuleBuilder implements ApplyableRuleBuilder {
    public void apply() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object other) {
        return other instanceof DefaultRuleBuilder;
    }

    public int hashCode() { return 0; }

    public RuleTarget multi(Class<?> type) {
        throw new UnsupportedOperationException();
    }

    public RuleTarget single(Class<?> type) {
        throw new UnsupportedOperationException();
    }
}
