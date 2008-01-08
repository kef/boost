package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class BlueprintedFactory implements Factory {
    private static final Stamp SINGLE = Stamp.SINGLE;
    private final BlueprintsRead blueprintsRead;

    public BlueprintedFactory(BlueprintsRead blueprintsRead) {
        this.blueprintsRead = blueprintsRead;
    }

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Blueprint blueprint = getBlueprint(iface);
        return provide(iface, provider, blueprint);
    }

    public Blueprint get(Interface iface, Implementation host) {
        return getBlueprint(iface);
    }

    public boolean canHandle(Interface iface) {
        return blueprintsRead.exists(iface);
    }

    public boolean isSingle(Interface iface) {
        Blueprint blueprint = getBlueprint(iface);
        Stamp stamp = blueprint.getStamp();
        return SINGLE.equals(stamp);
    }

    private Blueprint getBlueprint(Interface iface) {
        return blueprintsRead.get(iface);
    }

    private ResolvedInstance provide(Interface iface, ProviderEngine provider, Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        return provider.provide(iface, impl);
    }
}
