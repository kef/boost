package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.ImplementationRef;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private final Instances instances;
    private final Factories factories;
    private final ProviderEngine provider;

    public DefaultResolverEngine(Instances instances, Factories factories, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.provider = provider;
    }

    public ResolvedInstance resolve(Interface iface, ImplementationRef host) {
        if (instances.exists(iface)) return instances.get(iface);
        return factories.get(iface, host, provider, instances);
    }
}