package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface type;
    private InvocationHandler invocationHandler;
    private ProxyFactory proxyFactory;

    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier(proxyFactory, invocationHandler);
    }

    // FIX 1665 Do more here
    public void testCreate() {
//        proxyFactory.newProxy(type, invocationHandler);
        assertNull(subject.create(type));
    }
}
