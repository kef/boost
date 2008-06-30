package au.net.netstorm.boost.nursery.eight.legged.spider.web;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.RuleConfig;
import au.net.netstorm.boost.nursery.eight.legged.spider.core.SpiderConfig;
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
        register(factory);
    }

    public void register(Factory factory) {
        configure(factory);
        factories.add(factory);
    }

    public Binder binder() {
        return binder;
    }

    public void configure(Class<? extends SpiderConfig> config) {
        SpiderConfig instance = nu.nu(config);
        configure(instance);
    }

    public void configure(SpiderConfig config) {
        // FIX 2394 should there be an inject done on this guy?
        config.configure();
    }

    // FIX BREADCRUMB 2394 aaaa killing this
    public void register(RuleConfig ruleConfig) {
        ruleConfig.apply(binder);
    }

    private void configure(Factory factory) {
        if (!(factory instanceof ConfigurableFactory)) return;
        ConfigurableFactory configurable = (ConfigurableFactory) factory;
        configurable.configure(binder());
    }
}
