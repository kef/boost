package au.net.netstorm.boost.spider.inject.newer.assembly;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.newer.core.NewerInvocationHandler;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultNewerProxySupplierAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Implementation NEWER_INVOCATION_HANDLER = new DefaultImplementation(NewerInvocationHandler.class);
    NewerProxySupplier subject;
    Interface newerInterface;
    Implementation instanceImplementation;
    ProxyFactory proxyFactoryMock;
    Object newerProxy = new Object();
    ProviderEngine provider;
    InvocationHandler invocationHandler;
    Instantiator instantiatorMock;
    UnresolvedInstance unresolvedMock;

    public void setUpFixtures() {
        subject = new DefaultNewerProxySupplier(proxyFactoryMock, provider, instantiatorMock);
    }

    public void testCreate() {
        Object[] parameters = new Object[]{provider, instanceImplementation};
        expect.oneCall(instantiatorMock, unresolvedMock, "instantiate", NEWER_INVOCATION_HANDLER, parameters);
        expect.oneCall(unresolvedMock, invocationHandler, "getRef");
        expect.oneCall(proxyFactoryMock, newerProxy, "newProxy", newerInterface, invocationHandler);
        Object actual = subject.nu(newerInterface, instanceImplementation);
        assertSame(newerProxy, actual);
    }
}
