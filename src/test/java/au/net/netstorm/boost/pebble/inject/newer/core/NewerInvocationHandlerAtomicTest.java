package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class NewerInvocationHandlerAtomicTest extends InteractionTestCase {
    private InvocationHandler subject;
    private PebbleProviderEngine pebbleProvider;
    private Implementation impl;
    private Object proxyObject = new Object();
    private Object[] methodParams = new Object[]{};
    private Object newedObject = new Object();

    public void setupSubjects() {
        subject = new NewerInvocationHandler(pebbleProvider, impl);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(pebbleProvider, newedObject, "provide", impl, methodParams);
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(newedObject, actualObject);
    }
}
