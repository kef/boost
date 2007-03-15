package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.util.Random;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxySupplierAtomicTest extends InteractionTestCase {
    private NewerProxySupplier subject;
    private MockExpectations expect;
    private Interface newerInterface;
    private Class instanceImplementation = Random.class;
    private ProxyFactory proxyFactory;
    private Object newerProxy = new Object();
    private PebbleProviderEngine pebbleProvider;
    private InvocationHandler invocationHandler;
    private Instantiator instantiator;

    public void setupSubjects() {
        subject = new DefaultNewerProxySupplier(proxyFactory, pebbleProvider, instantiator);
    }

    public void testCreate() {
        Object[] parameters = new Object[]{pebbleProvider, instanceImplementation};
        expect.oneCall(instantiator, invocationHandler, "instantiate", NewerInvocationHandler.class, parameters);
        expect.oneCall(proxyFactory, newerProxy, "newProxy", newerInterface, invocationHandler);
        Object actual = subject.nu(newerInterface, instanceImplementation);
        assertSame(newerProxy, actual);
    }
}
