package au.net.netstorm.boost.spider.newer.assembly;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.spider.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.util.proxy.ProxyFactory;

public final class DefaultNewerProxySupplierAssembler implements NewerProxySupplierAssembler {
    private final ProxyFactoryAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();

    public NewerProxySupplier assemble(ProviderEngine providerEngine) {
        ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();
        Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
        return new DefaultNewerProxySupplier(proxyFactory, providerEngine, instantiator);
    }
}
