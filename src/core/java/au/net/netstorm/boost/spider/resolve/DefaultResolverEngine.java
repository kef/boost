package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.spider.registry.StampedResolvedInstance;
import au.net.netstorm.boost.util.type.Implementation;
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

    public synchronized ResolvedInstance resolve(Interface iface, Implementation host) {
        if (instances.exists(iface)) return instances.get(iface);
        return manufacture(iface, host);
    }

    private ResolvedInstance manufacture(Interface iface, Implementation host) {
        StampedResolvedInstance stamped = create(iface, host);
        return maintainInstances(iface, stamped);
    }

    private StampedResolvedInstance create(Interface iface, Implementation host) {
        Factory factory = factories.find(iface);
        return factory.get(iface, host, provider);
    }

    // FIX 2215 Keep refactoring here.
    private ResolvedInstance maintainInstances(Interface iface, StampedResolvedInstance stamped) {
        ResolvedInstance instance = stamped.getInstance();
        Stamp stamp = stamped.getStamp();
        if (stamp == Stamp.SINGLE) put(iface, instance);
        return instance;
    }

    // FIX 2215 Horrible hack!  Push this into the Provider Engine.
    private void put(Interface iface, ResolvedInstance instance) {
        if (!instances.exists(iface)) instances.put(iface, instance);
    }
}