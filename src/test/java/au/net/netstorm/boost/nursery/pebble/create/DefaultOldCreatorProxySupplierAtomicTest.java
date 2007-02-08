package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultOldCreatorProxySupplierAtomicTest extends PrimordialTestCase implements UsesMocks {
    private OldCreatorProxySupplier subject;
    private MockExpectations expect;
    private Interface type;
    private InvocationHandler invocationHandler;
    private ProxyFactory proxyFactory;
    private Object creatorProxy = new Object();

    public void setupSubjects() {
        subject = new DefaultOldCreatorProxySupplier(proxyFactory, invocationHandler);
    }

    public void testCreate() {
        expect.oneCall(proxyFactory, creatorProxy, "newProxy", type, invocationHandler);
        assertSame(creatorProxy, subject.create(type));
    }
}
