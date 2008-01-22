package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.nursery.spider.registry.Proxies;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX ()  94156 Getting a bit big.
public final class DefaultResolverEngine implements ResolverEngine {
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final Instances instances;
    private final Factories factories;
    private final Proxies proxies;
    private final ProviderEngine provider;

    public DefaultResolverEngine(Instances instances, Factories factories, Proxies proxies, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.proxies = proxies;
        this.provider = provider;
    }

    public synchronized ResolvedInstance resolve(Linkage linkage) {
        Factory factory = factories.find(linkage);
        Blueprint blueprint = factory.get(linkage);
        return get(linkage, blueprint);
    }

    private ResolvedInstance get(Linkage linkage, Blueprint blueprint) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        if (inProgress.exists(impl)) return inProgress.get(impl);
        if (instances.exists(iface, impl)) return instances.get(iface, impl);
        return manufacture(linkage, blueprint);
    }

    private ResolvedInstance manufacture(Linkage linkage, Blueprint blueprint) {
        ResolvedInstance instance = make(linkage, blueprint);
        if (isSingle(blueprint)) store(linkage, blueprint, instance);
        return instance;
    }

    private ResolvedInstance make(Linkage linkage, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        Object[] params = blueprint.getParameters();
        if (isProxy(linkage)) return proxy(linkage, impl, params);
        return provide(impl, params);
    }

    private boolean isSingle(Blueprint blueprint) {
        Stamp stamp = blueprint.getStamp();
        return stamp.equals(SINGLE);
    }

    private void store(Linkage linkage, Blueprint blueprint, ResolvedInstance instance) {
        Interface iface = linkage.getIface();
        Implementation impl = blueprint.getImplementation();
        instances.put(iface, impl, instance);
    }

    private boolean isProxy(Linkage linkage) {
        return proxies.exists(linkage);
    }

    private ResolvedInstance proxy(Linkage linkage, Implementation impl, Object[] params) {
        Class<? extends Layer>[] layers = proxies.get(linkage);
        Interface iface = linkage.getIface();
        return provider.provide(iface, impl, params, layers);
    }

    private ResolvedInstance provide(Implementation impl, Object[] params) {
        return provider.provide(impl, params);
    }
}