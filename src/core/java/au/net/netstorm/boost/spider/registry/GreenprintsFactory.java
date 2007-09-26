package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1914 This feels bad. Centralise operations on Instances somehow.
public final class GreenprintsFactory implements Factory {
    private Greenprints greenprints;

    public GreenprintsFactory(Greenprints greenprints) {
        this.greenprints = greenprints;
    }

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider, Instances instances) {
        Blueprint blueprint = greenprints.get(iface);
        Implementation impl = blueprint.getImplementation();
        ResolvedInstance result = provider.provide(impl);
        maintainInstance(iface, instances, blueprint, result);
        return result;
    }

    public boolean canHandle(Interface iface) {
        return greenprints.exists(iface);
    }

    private void maintainInstance(Interface iface, Instances instances, Blueprint blueprint, ResolvedInstance result) {
        if (!single(blueprint)) return;
        if (instances.exists(iface)) return;
        instances.put(iface, result);
    }

    private boolean single(Blueprint blueprint) {
        Stamp stamp = blueprint.getStamp();
        return stamp == Stamp.SINGLE;
    }
}
