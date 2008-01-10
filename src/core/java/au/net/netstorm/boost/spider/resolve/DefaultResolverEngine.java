package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.nursery.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final Instances instances;
    private final Factories factories;
    private final ProviderEngine provider;

    public DefaultResolverEngine(Instances instances, Factories factories, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.provider = provider;
    }

    public synchronized ResolvedInstance resolve(Linkage linkage) {
        Factory factory = factories.find(linkage);
        Blueprint blueprint = factory.get(linkage);
        Interface iface = linkage.getIface();
        return get(iface, blueprint);
    }

    private ResolvedInstance get(Interface iface, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        Object[] params = blueprint.getParameters();
        Stamp stamp = blueprint.getStamp();
        return get(iface, impl, params, stamp);
    }

    private ResolvedInstance get(Interface iface, Implementation impl, Object[] params, Stamp stamp) {
        if (inProgress.exists(impl)) return inProgress.get(impl);
        if (instances.exists(iface, impl)) return instances.get(iface, impl);
        return manufacture(iface, impl, params, stamp);
    }

    private ResolvedInstance manufacture(Interface iface, Implementation impl, Object[] params, Stamp stamp) {
        ResolvedInstance instance = provider.provide(impl, params);
        store(iface, impl, instance, stamp);
        return instance;
    }

    private void store(Interface iface, Implementation impl, ResolvedInstance instance, Stamp stamp) {
        boolean isSingle = stamp.equals(Stamp.SINGLE);
        if (isSingle) instances.put(iface, impl, instance);
    }
}