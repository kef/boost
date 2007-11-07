package au.net.netstorm.boost.spider.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerInvocationHandlerAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Object[] NO_PARAMS = new Object[0];
    private Interface iface = new DefaultInterface(Coke.class);
    EdgeClass classer = new DefaultEdgeClass();
    InvocationHandler subject;
    ProviderEngine providerMock;
    Implementation impl;
    Object proxyObject;
    ResolvedInstance newedInstanceMock;
    Object newedObject;

    public void setUpFixtures() {
        subject = new NewerInvocationHandler(providerMock, impl);
    }

    public void testInvokeNu() throws Throwable {
        checkInvokeWithNoParameters();
    }

    public void testInvokeOtherMethod() throws Throwable {
        Method method = method("bogus");
        checkFails(method, NO_PARAMS);
    }

    public void testInvokeBadNu() throws Throwable {
        Class[] types = {Integer.class};
        Method method = method("nu", types);
        Object[] args = {new Integer(1)};
        checkFails(method, args);
    }

    private void checkFails(Method method, Object[] args) throws Throwable {
        try {
            subject.invoke(proxyObject, method, args);
            fail();
        } catch (IllegalStateException expected) { }
    }

    private void checkInvokeWithNoParameters() throws Throwable {
        check(NO_PARAMS);
        check(null);
    }

    private void check(Object[] params) throws Throwable {
        Method method = method("nu");
        expect.oneCall(providerMock, newedInstanceMock, "provide", iface, impl, NO_PARAMS);
        expect.oneCall(newedInstanceMock, newedObject, "getRef");
        Object actualObject = subject.invoke(proxyObject, method, params);
        assertSame(newedObject, actualObject);
    }

    private Method method(String name) {
        return method(name, null);
    }

    private Method method(String name, Class[] parameterTypes) {
        return classer.getMethod(NewVanillaCoke.class, name, parameterTypes);
    }
}
