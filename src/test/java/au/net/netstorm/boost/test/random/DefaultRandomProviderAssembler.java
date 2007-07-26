package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.spider.inject.newer.assembly.DefaultProxyFactoryAssembler;
import au.net.netstorm.boost.spider.inject.newer.assembly.ProxyFactoryAssembler;
import au.net.netstorm.boost.spider.onion.layer.passthrough.DefaultPassThroughLayer;
import au.net.netstorm.boost.spider.onion.layer.passthrough.PassThroughLayer;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.automock.DefaultAutoMocker;
import au.net.netstorm.boost.test.automock.DefaultMockObjectTestCase;
import au.net.netstorm.boost.test.automock.DefaultMockProvider;
import au.net.netstorm.boost.test.automock.MockObjectTestCase;
import au.net.netstorm.boost.test.automock.MockProvider;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRandomProviderAssembler implements RandomProviderAssembler {
    private static final Interface RANDOM_PROVIDER = new DefaultInterface(SpecificProvider.class);
    private ProxyFactoryAssembler proxyFactoryAssembler = new DefaultProxyFactoryAssembler();
    private ProxyFactory proxyFactory = proxyFactoryAssembler.assemble();
    private PassThroughLayer passThrough = new DefaultPassThroughLayer();

    public Provider everything(DataProviders providers) {
        AutoMocker mocker = createAutoMocker();
        return assemble(providers, mocker);
    }

    public Provider everything(DataProviders providers, AutoMocker mocker) {
        return assemble(providers, mocker);
    }

    private AutoMocker createAutoMocker() {
        // FIX 2076 CARD Get field checkers using same MockObjectTestCase to tests.
        MockObjectTestCase mockTestCase = new DefaultMockObjectTestCase();
        MockProvider mockProvider = new DefaultMockProvider(mockTestCase);
        return new DefaultAutoMocker(mockProvider);
    }

    private Provider assemble(DataProviders providers, AutoMocker mocker) {
        SpecificProvider passthrough = (SpecificProvider) proxyFactory.newProxy(RANDOM_PROVIDER, passThrough);
        EverythingRandomProvider result = new EverythingRandomProvider(passthrough);
        Provider interfaces = new InterfaceRandomProvider(result, providers, mocker);
        passThrough.setDelegate(interfaces);
        return result;
    }
}
