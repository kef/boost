package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.bullet.provider.Provider;
import au.net.netstorm.boost.bullet.provider.Random;
import au.net.netstorm.boost.bullet.provider.SpecificProvider;
import au.net.netstorm.boost.gunge.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.EnumProvider;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;

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
