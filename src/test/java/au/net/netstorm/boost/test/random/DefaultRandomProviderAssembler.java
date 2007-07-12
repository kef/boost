package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.specific.Targetted;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRandomProviderAssembler implements RandomProviderAssembler {
    // FIX 2076 Remove dupe with spider for creating passthrough proxies.
    private static final Interface RANDOM_PROVIDER = new DefaultInterface(Provider.class);
    private ProxyFactory proxyFactory = assembleProxyFactory();
    private PassThroughLayer passThrough = new DefaultPassThroughLayer();

    public Provider everything(Targetted registry) {
        Provider passthrough = (Provider) proxyFactory.newProxy(RANDOM_PROVIDER, passThrough);
        EverythingRandomProvider result = new EverythingRandomProvider(passthrough);
        Provider interfaces = new InterfaceRandomProvider(result, registry);
        passThrough.setDelegate(interfaces);
        return result;
    }

    private ProxyFactory assembleProxyFactory() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }
}
