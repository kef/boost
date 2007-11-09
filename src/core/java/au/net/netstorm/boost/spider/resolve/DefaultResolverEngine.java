package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.newer.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.newer.PartialInstances;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    // FIX 2215 Call this singles?
    private final Instances instances;
    private final Factories factories;
    private final ProviderEngine provider;
    private final PartialInstances inProgress = new DefaultPartialInstances();

    public DefaultResolverEngine(Instances instances, Factories factories, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.provider = provider;
    }

    public synchronized ResolvedInstance resolve(Interface iface, Implementation host) {
        if (instances.exists(iface)) return instances.get(iface);
        // FIX 2215 Moved here from ProviderEngine.  Is the right place yet?
        if (inProgress.exists(iface)) return inProgress.get(iface);
        return manufacture(iface, host);
    }

    private ResolvedInstance manufacture(Interface iface, Implementation host) {
        Factory factory = factories.find(iface);
        ResolvedInstance instance = factory.get(iface, host, provider);
        boolean isSingle = factory.isSingle(iface);
        if (isSingle) instances.put(iface, instance);
        return instance;
    }
}