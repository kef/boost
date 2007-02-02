package au.net.netstorm.boost.nursery.pebble.create;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxySupplier;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorInjector subject;
    private MockExpectations expect;
    private ProxyFactory proxyFactory;
    private EdgeProxySupplier edgeProxySupplier;
    private InvocationHandler creationInvocationHandler;
    private MockableObject objectToInject;
    
    public void setupSubjects() {
        subject = new DefaultCreatorInjector(creationInvocationHandler, proxyFactory);
    }

    public void testInject() {
        Interface type = new DefaultInterface(Serializable.class);
        expect.oneCall(proxyFactory, edgeProxySupplier, "newProxy", type, creationInvocationHandler);
        subject.inject(objectToInject);
    }

    private interface MockableObject { 
    }

}
