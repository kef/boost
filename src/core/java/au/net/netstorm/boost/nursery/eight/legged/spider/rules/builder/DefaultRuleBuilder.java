package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rules;

// FIX 2394 work out if this is really how i want to do it, looks a little scary
public final class DefaultRuleBuilder implements ApplyableRuleBuilder {
    private final Rules rules;

    public DefaultRuleBuilder(Rules rules) {
        this.rules = rules;
    }

    public RulePattern type(Class<?> type) {
        /// FIX 2394 build state
        return null;
    }

    public RulePattern pattern(Class<?> host, Class<?> type, String name) {
        /// FIX 2394 build state
        return null;
    }

    public RulePattern pattern(InjectionPattern pattern) {
        /// FIX 2394 build state
        return null;
    }

    public void to(Factory factory) {
        throw new UnsupportedOperationException();
    }

    public void to(Object instance) {
        throw new UnsupportedOperationException();
    }

    public void to(Class<?> impl) {
        throw new UnsupportedOperationException();
    }

    public void apply() {
        // FIX 2394 validate and save rule
    }
}
