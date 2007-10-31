package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1914 This feels bad. Centralise operations on Instances somehow.
public final class GreenprintsFactory implements Factory {
    private final Greenprints greenprints;
    private final Instances instances;

    public GreenprintsFactory(Greenprints greenprints, Instances instances) {
        this.greenprints = greenprints;
        this.instances = instances;
    }

    // FIX 2215 Should we return an object like BlueObject which has the reference and a SINGLE/MULTIPLE.
    // FIX 2215 Probably not.
    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Blueprint blueprint = greenprints.get(iface);
        Implementation impl = blueprint.getImplementation();
        ResolvedInstance result = provider.provide(impl);
        register(iface, blueprint, result);
        return result;
    }

    public boolean canHandle(Interface iface) {
        return greenprints.exists(iface);
    }

    private void register(Interface iface, Blueprint blueprint, ResolvedInstance result) {
        if (!single(blueprint)) return;
        instances.put(iface, result);
    }

    private boolean single(Blueprint blueprint) {
        Stamp stamp = blueprint.getStamp();
        return stamp == Stamp.SINGLE;
    }
}
