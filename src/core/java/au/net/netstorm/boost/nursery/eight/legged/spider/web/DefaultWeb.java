package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.DefaultBinder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultWeb implements Web {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final NuImpl nu;
    private final Factories factories;
    private final Binder binder;

    public DefaultWeb(NuImpl nu, Bindings bindings, Factories factories) {
        this.nu = nu;
        this.factories = factories;
        this.binder = new DefaultBinder(bindings);
    }

    public void register(Class<? extends Factory> type) {
        Factory factory = nu.nu(type);
        register(factory);
    }

    public void register(Factory factory) {
        configure(factory);
        factories.add(factory);
    }

    public Binder binder() {
        return binder;
    }

    public void register(RuleConfig ruleConfig) {
        ruleConfig.apply(binder);
    }

    private void configure(Factory factory) {
        if (!(factory instanceof ConfigurableFactory)) return;
        ConfigurableFactory configurable = (ConfigurableFactory) factory;
        configurable.configure(binder());
    }
}
