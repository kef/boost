package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.config.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.DefaultBinder;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultWeb implements Web {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Bindings bindings;
    private final Factories factories;

    public DefaultWeb(Bindings bindings, Factories factories) {
        this.bindings = bindings;
        this.factories = factories;
    }

    public void register(Class<? extends Factory> type) {
        Factory factory = classer.newInstance(type);
        register(factory);
    }

    public void register(Factory factory) {
        configure(factory);
        factories.add(factory);
    }

    public Binder binder() {
        return new DefaultBinder(bindings);
    }

    public void register(RuleConfig ruleConfig) {
        Binder binder = binder();
        ruleConfig.apply(binder);
    }

    private void configure(Factory factory) {
        if (!(factory instanceof ConfigurableFactory)) return;
        ConfigurableFactory configurable = (ConfigurableFactory) factory;
        configurable.configure(binder());
    }
}
