package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1914 This feels bad. Centralise operations on Instances somehow.
public final class BlueprintedFactory implements Factory {
    private final BlueprintsRead blueprintsRead;
    private final Instances instances;

    public BlueprintedFactory(BlueprintsRead blueprintsRead, Instances instances) {
        this.blueprintsRead = blueprintsRead;
        this.instances = instances;
    }

    // FIX 2215 Should we return an object like BlueObject which has the reference and a SINGLE/MULTIPLE.
    // FIX 2215 Probably not.
    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Blueprint blueprint = blueprintsRead.get(iface);
        Implementation impl = blueprint.getImplementation();
        ResolvedInstance result = provider.provide(impl);
        register(iface, blueprint, result);
        return result;
    }

    public boolean canHandle(Interface iface) {
        return blueprintsRead.exists(iface);
    }

    private void register(Interface iface, Blueprint blueprint, ResolvedInstance instance) {
        if (single(blueprint)) instances.put(iface, instance);
    }

    private boolean single(Blueprint blueprint) {
        Stamp stamp = blueprint.getStamp();
        return stamp == Stamp.SINGLE;
    }
}
