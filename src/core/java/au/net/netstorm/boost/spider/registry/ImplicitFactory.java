package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class ImplicitFactory implements Factory {
    private final ImplMaster impler;

    public ImplicitFactory(ImplMaster impler) {
        this.impler = impler;
    }

    public StampedResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Implementation impl = impler.impl(iface);
        ResolvedInstance instance = provider.provide(iface, impl);
        return new DefaultStampedResolvedInstance(instance, Stamp.SINGLE);
    }

    public boolean canHandle(Interface iface) {
        return impler.hasImpl(iface);
    }

    public boolean isSingle(Interface iface) {
        return true;
    }
}
