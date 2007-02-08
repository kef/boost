package au.net.netstorm.boost.nursery.pebble.create;

import java.util.Random;
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

    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier(proxyFactory, creator);
    }

    public void testCreate() {
        subject.create(creatorInterface, instanceImplementation);
//        expect.oneCall(proxyFactory, creatorProxy, "newProxy", creatorType, is);
//        assertSame(creatorProxy, subject.create(type));
    }
/*
    private ProxyFactory proxyFactory;
    private GenericCreator genericCreator;

    public DefaultCreatorProxySupplier(ProxyFactory proxyFactory, GenericCreator genericCreator) {
        this.proxyFactory = proxyFactory;
        this.genericCreator = genericCreator;
    }

    public Object create(Class instanceImplementation, Interface creatorInterface) {
        InvocationHandler invocationHandler = new CreatorInvocationHandler(genericCreator, instanceImplementation);
        return proxyFactory.newProxy(creatorInterface, invocationHandler);
    }
*/
}
