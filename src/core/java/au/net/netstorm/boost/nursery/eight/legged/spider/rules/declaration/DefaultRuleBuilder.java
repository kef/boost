package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.DefaultKeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

public final class DefaultRuleBuilder implements RuleBuilder {
    private boolean single = false;
    private Factory factory;
    private Class<?> host;
    private String name;

    // FIX 2394 add ctor that accepts the iface
    
    public Rule build() {
        return new DefaultKeyedRule(factory, single, host, name);
    }

    public void setMapping(Factory factory) {
        this.factory = factory;
    }

    public void setIsSingleton(boolean single) {
        this.single = single;
    }

    public void setScope(Class<?> host, String name) {
        this.host = host;
        this.name = name;
    }
}
