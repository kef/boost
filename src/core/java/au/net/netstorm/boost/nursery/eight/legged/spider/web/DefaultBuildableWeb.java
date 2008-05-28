package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.DefaultRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder.ApplyableRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.DefaultRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver.RuleResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver.DefaultRuleResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;

public final class DefaultBuildableWeb implements BuildableWeb {
    private final Rules rules = new DefaultRules();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final RuleResolver resolver = new DefaultRuleResolver(rules);
    private final InjectionWeb injections = new DefaultInjectionWeb(resolver);

    public void register(Class<? extends Factory> type) {
        Factory factory = classer.newInstance(type);
        register(factory);
    }

    public void register(Factory factory) {
        // FIX 2394 this needs to registered as a wildcard tule
//        configure(factory);
//        factories.add(factory);
    }

    public void register(RuleConfig ruleConfig) {
        ApplyableRuleBuilder builder = new DefaultRuleBuilder(rules);
        ruleConfig.apply(builder);
        builder.apply();
    }

    public GraphBuilder builder() {
        return new DefaultGraphBuilder(injections);
    }

    // FIX 2394 find a home for me
//    private void configure(Factory factory) {
//        if (!(factory instanceof ConfigurableFactory)) return;
//        ConfigurableFactory configurable = (ConfigurableFactory) factory;
//        configurable.configure(this);
//    }
}
