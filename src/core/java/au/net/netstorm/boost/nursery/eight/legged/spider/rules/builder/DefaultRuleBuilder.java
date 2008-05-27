package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2394 work out if this is really how i want to do it, looks a little scary
public final class DefaultRuleBuilder implements ApplyableRuleBuilder, RuleTarget, RuleScope {
    // FIX 2394 break this out into the three seperate phases
    private final Rules rules;
    private boolean single;
    // FIX 2394 create to/from holder
    private Object from;
    private Object to;
    private Class<?> host;
    private String name;

    public DefaultRuleBuilder(Rules rules) {
        this.rules = rules;
    }

    public RuleTarget multi(Class<?> type) {
        from = type;
        single = false;
        return this;
    }

    public RuleTarget single(Class<?> type) {
        from = type;
        single = true;
        return this;
    }

    public RuleScope to(Factory factory) {
        to = factory;
        return this;
    }

    public RuleScope to(Object instance) {
        to = instance;
        return this;
    }

    public RuleScope to(Class<?> impl) {
        to = impl;
        return this;
    }

    public void in(Class<?> host) {
        this.host = host;
    }

    public void in(Class<?> host, String name) {
        this.host = host;
        this.name = name;
    }

    public void in(String name) {
        this.name = name;
    }

    public void apply() {
        // FIX 2394 validate and save rule
    }
}
