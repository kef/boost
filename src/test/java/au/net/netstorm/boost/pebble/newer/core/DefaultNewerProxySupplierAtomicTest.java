package au.net.netstorm.boost.pebble.newer.core;

import java.lang.reflect.InvocationHandler;
import java.util.Random;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private NewerProxySupplier subject;
    private MockExpectations expect;
    private Interface creatorInterface;
    private Class instanceImplementation = Random.class;
    private ProxyFactory proxyFactory;
    private Object creatorProxy = new Object();
    private ObjectProvider objectProvider;
    private InvocationHandler invocationHandler;
    private Instantiator instantiator;

    public void setupSubjects() {
        subject = new DefaultNewerProxySupplier(proxyFactory, objectProvider, instantiator);
    }

    public void testCreate() {
        Object[] parameters = new Object[]{objectProvider, instanceImplementation};
        expect.oneCall(instantiator, invocationHandler, "instantiate", NewerInvocationHandler.class, parameters);
        expect.oneCall(proxyFactory, creatorProxy, "newProxy", creatorInterface, invocationHandler);
        Object actual = subject.create(creatorInterface, instanceImplementation);
        assertSame(creatorProxy, actual);
    }
}
