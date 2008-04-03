package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.gunge.automock.MockSupport;
import au.net.netstorm.boost.gunge.specific.DataProviders;
import au.net.netstorm.boost.gunge.specific.EnumProvider;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRandomProviderAssembler implements RandomProviderAssembler {
    private static final Interface RANDOM_PROVIDER = new DefaultInterface(SpecificProvider.class);
    private ProxyFactory proxyFactory = new DefaultProxyFactory();
    private PassThroughLayer passThrough = new DefaultPassThroughLayer();

    // FIX (Dec 17, 2007) CORE SPLIT 84836 Can DataProviders and EnumProvider be merged?
    public Random everything(DataProviders data, EnumProvider enums, MockSupport mocks) {
        return assemble(data, enums, mocks);
    }

    private Random assemble(DataProviders data, EnumProvider enums, MockSupport mocks) {
        SpecificProvider passthrough = (SpecificProvider) proxyFactory.newProxy(RANDOM_PROVIDER, passThrough);
        EverythingRandomProvider result = new EverythingRandomProvider(passthrough, enums);
        Provider interfaces = new InterfaceRandomProvider(result, data, enums, mocks);
        passThrough.setDelegate(interfaces);
        return result;
    }
}
