package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.DefaultKeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultRuleBuilder implements RuleBuilder {
    private final InjectionType type;
            // FIX 2394 do something with single, should be wrapping factory
    private boolean single = false;
    private Factory factory;
    private Matcher matcher;

    public DefaultRuleBuilder(InjectionType type) {
        this.type = type;
    }

    public KeyedRule build() {
        return new DefaultKeyedRule(type, factory, matcher);
    }

    public void setMapping(Factory factory) {
        this.factory = factory;
    }

    public void setIsSingleton(boolean single) {
        this.single = single;
    }

    public void setScope(Matcher matcher) {
        this.matcher = matcher;
    }
}
