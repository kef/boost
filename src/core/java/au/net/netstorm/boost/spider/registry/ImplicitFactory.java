package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class ImplicitFactory implements Factory {
    private static final Object[] NO_PARAMS = {};
    private final ImplMaster impler;

    public ImplicitFactory(ImplMaster impler) {
        this.impler = impler;
    }

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Implementation impl = impler.impl(iface);
        return provider.provide(iface, impl);
    }

    public Blueprint get(Interface iface, Implementation host) {
        Implementation impl = impler.impl(iface);
        return new DefaultBlueprint(Stamp.SINGLE, impl, NO_PARAMS);
    }

    public boolean canHandle(Interface iface) {
        return impler.hasImpl(iface);
    }

    public boolean isSingle(Interface iface) {
        return true;
    }
}
