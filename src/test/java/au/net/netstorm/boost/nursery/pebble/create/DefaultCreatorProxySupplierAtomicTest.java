package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface type;
    private EdgeProxySupplier edgeProxySupplier;
    // FIX 1665 fix
    private ClassLoader classLoader = this.getClass().getClassLoader();
    private InvocationHandler invocationHandler;


    public void setupSubjects() {
        subject = new DefaultCreatorProxySupplier(classLoader, invocationHandler, edgeProxySupplier);
    }

    // FIX 1665 Do more here
    public void testCreate() {
        // edgeProxy.getProxy(classLoader, new Class[]{type.getClass()}, invocationHandler);
        // expect.oneCall(edgeProxySupplier, creatorProxy, "getProxy", classLoader, typesToProxy, invocationHandler);
        assertNull(subject.create(type));
    }
}
