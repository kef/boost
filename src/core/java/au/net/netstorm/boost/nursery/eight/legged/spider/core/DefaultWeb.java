package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ConfigurableFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultWeb implements Web {
    private final NuImpl nu;
    private final Factories factories;
    private final Binder binder;

    public DefaultWeb(NuImpl nu, Binder binder, Factories factories) {
        this.nu = nu;
        this.factories = factories;
        this.binder = binder;
    }

    public void register(Class<? extends Factory> type) {
        Factory factory = nu.nu(type);
        configure(factory);
        factories.add(factory);
    }

    public void configure(Class<? extends SpiderConfig> config) {
        SpiderConfig instance = nu.nu(config);
        instance.configure();
    }

    private void configure(Factory factory) {
        if (!(factory instanceof ConfigurableFactory)) return;
        ConfigurableFactory configurable = (ConfigurableFactory) factory;
        configurable.configure(binder);
    }
}
