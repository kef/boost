package au.net.netstorm.boost.spider.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerInvocationHandlerAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    EdgeClass classer = new DefaultEdgeClass();
    InvocationHandler subject;
    ProviderEngine providerMock;
    Implementation impl;
    Object proxyObject;
    ResolvedInstance newedInstanceMock;
    Object[] methodParams = new Object[]{};
    Object newedObject;

    public void setUpFixtures() {
        subject = new NewerInvocationHandler(providerMock, impl);
    }

    public void testInvokeNu() throws Throwable {
        Method method = method("nu");
        expect.oneCall(providerMock, newedInstanceMock, "provide", impl, methodParams);
        expect.oneCall(newedInstanceMock, newedObject, "getRef");
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(newedObject, actualObject);
    }

    public void testInvokeOtherMethod() throws Throwable {
        Method method = method("bogus");
        try {
            subject.invoke(proxyObject, method, methodParams);
            fail();
        } catch (IllegalStateException expected) { }
    }

    private Method method(String name) {
        return classer.getMethod(NewVanillaCoke.class, name, null);
    }

    // FIX 1887 Test path where method is not "nu".
}
