package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface type;
    private ProxyFactory proxyFactory;
    private Object creatorProxy = new Object();
    private Creator creator;

    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier(proxyFactory, creator);
    }

    public void testCreate() {
        subject.create(null);
// FIX BREADCRUMB 1665 -10000000 Back here and complete.
//        expect.oneCall(proxyFactory, creatorProxy, "newProxy", type, invocationHandler);
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
