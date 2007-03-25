package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxySupplierAtomicTest extends InteractionTestCase {
    private static final Implementation NEWER_INVOCATION_HANDLER = new DefaultImplementation(NewerInvocationHandler.class);
    NewerProxySupplier subject;
    Interface newerInterface;
    Implementation instanceImplementation;
    ProxyFactory proxyFactory;
    Object newerProxy = new Object();
    PebbleProviderEngine pebbleProvider;
    InvocationHandler invocationHandler;
    Instantiator instantiator;

    public void setupSubjects() {
        subject = new DefaultNewerProxySupplier(proxyFactory, pebbleProvider, instantiator);
    }

    public void testCreate() {
        Object[] parameters = new Object[]{pebbleProvider, instanceImplementation};
        expect.oneCall(instantiator, invocationHandler, "instantiate", NEWER_INVOCATION_HANDLER, parameters);
        expect.oneCall(proxyFactory, newerProxy, "newProxy", newerInterface, invocationHandler);
        Object actual = subject.nu(newerInterface, instanceImplementation);
        assertSame(newerProxy, actual);
    }
}
