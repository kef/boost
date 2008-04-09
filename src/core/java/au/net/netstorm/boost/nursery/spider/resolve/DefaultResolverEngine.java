package au.net.netstorm.boost.nursery.spider.resolve;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.register.Blueprint;
import au.net.netstorm.boost.spider.register.Factories;
import au.net.netstorm.boost.spider.register.Factory;
import au.net.netstorm.boost.spider.register.Instances;
import au.net.netstorm.boost.spider.register.Stamp;
import static au.net.netstorm.boost.spider.register.Stamp.SINGLE;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;

// FIX 2299 Up coverage and out of nursery.
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
        if (isSingle(stamp)) store(iface, impl, instance);
        return instance;
    }

    private void store(Interface iface, Implementation impl, ResolvedInstance instance) {
        instances.put(iface, impl, instance);
    }

    private boolean isSingle(Stamp stamp) {
        return stamp.equals(SINGLE);
    }
}