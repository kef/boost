package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.GodLock;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private static final Object LOCK = GodLock.LOCK;
    private final Instances instances;
    private final Factories factories;
    private final ProviderEngine provider;

    public DefaultResolverEngine(Instances instances, Factories factories, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.provider = provider;
    }

    // FIX 2183 Sort out synchronisation.
    // FIX 2183 Do we really need a lock on ProviderEngine.
    public ResolvedInstance resolve(Interface iface, Implementation host) {
        synchronized (LOCK) { return doResolve(iface, host); }
    }

    private ResolvedInstance doResolve(Interface iface, Implementation host) {
        if (instances.exists(iface)) return instances.get(iface);
        return manufacture(iface, host);
    }

    private ResolvedInstance manufacture(Interface iface, Implementation host) {
        Factory factory = factories.find(iface);
        return factory.get(iface, host, provider, instances);
    }
}