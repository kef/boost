package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class ImplicitFactory implements Factory {
    private final ImplMaster impler;
    private final Instances instances;

    public ImplicitFactory(ImplMaster impler, Instances instances) {
        this.impler = impler;
        this.instances = instances;
    }

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        Implementation impl = impler.impl(iface);
        ResolvedInstance instance = provider.provide(impl);
        // FIX 2215 Hideous hack! Instances can appear AFTER DefaultResolverEngine has established non-existence!
        if (instances.exists(iface)) return instance;
        instances.put(iface, instance);
        return instance;
    }

    public boolean canHandle(Interface iface) {
        return impler.hasImpl(iface);
    }
}
