package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.Ruler;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration.DefaultRuler;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;

public final class DefaultWeb implements Web {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Rules rules;

    public DefaultWeb(Rules rules) {
        this.rules = rules;
    }

    public void register(Class<? extends Factory> type) {
        Factory factory = classer.newInstance(type);
        register(factory);
    }

    public void register(Factory factory) {
        // FIX 2394 this needs to registered as a wildcard tule
//        configure(factory);
//        factories.add(factory);
    }

    public Ruler rule() {
        return new DefaultRuler(rules);
    }

    public void register(RuleConfig ruleConfig) {
        Ruler rule = rule();
        ruleConfig.apply(rule);
    }



// FIX 2394 find a home for me
//    private void configure(Factory factory) {
//        if (!(factory instanceof ConfigurableFactory)) return;
//        ConfigurableFactory configurable = (ConfigurableFactory) factory;
//        configurable.configure(this);
//    }
}
