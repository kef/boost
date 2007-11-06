package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 1914 This feels bad. Centralise operations on Instances somehow.
public final class BlueprintedFactory implements Factory {
    private final BlueprintsRead blueprintsRead;

    public BlueprintedFactory(BlueprintsRead blueprintsRead) {
        this.blueprintsRead = blueprintsRead;
    }

    // FIX 2215 Should we return an object like BlueObject which has the reference and a SINGLE/MULTIPLE.
    // FIX 2215 Probably not.
    public StampedResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Blueprint blueprint = blueprintsRead.get(iface);
        ResolvedInstance instance = provide(iface, provider, blueprint);
        return stamp(blueprint, instance);
    }

    public boolean canHandle(Interface iface) {
        return blueprintsRead.exists(iface);
    }

    private ResolvedInstance provide(Interface iface, ProviderEngine provider, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        return provider.provide(iface, impl);
    }

    private StampedResolvedInstance stamp(Blueprint blueprint, ResolvedInstance result) {
        Stamp stamp = blueprint.getStamp();
        return new DefaultStampedResolvedInstance(result, stamp);
    }
}
