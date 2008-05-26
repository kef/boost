package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.GraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.DefaultGraphBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.RuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.DefaultRuleBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.rules.DefaultRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.multiplicity.Multiplicity;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.DefaultFactories;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ConfigurableFactory;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;

public final class DefaultBuildableWeb implements BuildableWeb {
    private final Factories factories = new DefaultFactories();
    private final Rules rules = new DefaultRules();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void register(Rule rule) {
        rules.add(rule);
    }

    public void register(Class<? extends Factory> type) {
        Factory factory = classer.newInstance(type);
        register(factory);
    }

    public void register(Factory factory) {
        configure(factory);
        factories.add(factory);
    }

    public RuleBuilder bind(Multiplicity multiplicity) {
        return new DefaultRuleBuilder(this, multiplicity);
    }

    public GraphBuilder builder() {
        return new DefaultGraphBuilder(rules, factories);
    }

    private void configure(Factory factory) {
        if (!(factory instanceof ConfigurableFactory)) return;
        ConfigurableFactory configurable = (ConfigurableFactory) factory;
        configurable.configure(this);
    }
}
