package au.net.netstorm.boost.nursery.eight.legged.spider.rules;

import au.net.netstorm.boost.nursery.eight.legged.spider.web.Web;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns.InjectionPattern;

public final class MultiRuleBuilder implements RuleBuilder {
    public MultiRuleBuilder(Web web) {
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
