package au.net.netstorm.boost.spider.inject.newer;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.newer.core.DefaultNewerProxySupplier;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultOldPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.OldPassThroughLayer;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxySupplierAssembler implements NewerProxySupplierAssembler {
    private static final Interface OBJECT_PROVIDER_TYPE = new DefaultInterface(ProviderEngine.class);
    private final ProxySupplierAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();

    public NewerProxySupplier assemble() {
        ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        OldPassThroughLayer passThrough = new DefaultOldPassThroughLayer();
        ProviderEngine passThroughProvider = (ProviderEngine) proxyFactory.newProxy(OBJECT_PROVIDER_TYPE, passThrough);
        return new DefaultNewerProxySupplier(proxyFactory, passThroughProvider, instantiator);
    }
}
