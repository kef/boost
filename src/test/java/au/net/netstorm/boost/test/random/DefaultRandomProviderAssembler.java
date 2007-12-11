package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.EnumDataProviders;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactoryAssembler;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRandomProviderAssembler implements RandomProviderAssembler {
    private static final Interface RANDOM_PROVIDER = new DefaultInterface(SpecificProvider.class);
    private ProxyFactoryAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();
    private ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();
    private PassThroughLayer passThrough = new DefaultPassThroughLayer();

    public Random everything(DataProviders dataProviders, EnumDataProviders enumProviders, MockSupport mocks) {
        return assemble(dataProviders, enumProviders, mocks);
    }

    private Random assemble(DataProviders dataProviders, EnumDataProviders enumProviders, MockSupport mocks) {
        SpecificProvider passthrough = (SpecificProvider) proxyFactory.newProxy(RANDOM_PROVIDER, passThrough);
        EverythingRandomProvider result = new EverythingRandomProvider(passthrough);
        Provider interfaces = new InterfaceRandomProvider(result, dataProviders, enumProviders, mocks);
        passThrough.setDelegate(interfaces);
        return result;
    }
}
