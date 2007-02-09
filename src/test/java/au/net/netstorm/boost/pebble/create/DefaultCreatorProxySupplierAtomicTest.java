package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.util.Random;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface creatorInterface;
    private Class instanceImplementation = Random.class;
    private ProxyFactory proxyFactory;
    private Object creatorProxy = new Object();
    private Creator creator;
    private InvocationHandler invocationHandler;
    private Instantiator instantiator;

    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier(proxyFactory, creator, instantiator);
    }

    public void testCreate() {
        Object[] parameters = new Object[]{creator, instanceImplementation};
        expect.oneCall(instantiator, invocationHandler, "instantiate", CreatorInvocationHandler.class, parameters);
        expect.oneCall(proxyFactory, creatorProxy, "newProxy", creatorInterface, invocationHandler);
        Object actual = subject.create(creatorInterface, instanceImplementation);
        assertSame(creatorProxy, actual);
    }
}
