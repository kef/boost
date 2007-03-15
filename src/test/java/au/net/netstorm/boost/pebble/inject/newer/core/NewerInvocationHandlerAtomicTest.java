package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class NewerInvocationHandlerAtomicTest extends InteractionTestCase {
    private InvocationHandler subject;
    private MockExpectations expect;
    private PebbleProviderEngine pebbleProvider;
    private Class implClass = Random.class;
    private Object proxyObject = new Object();
    private Object[] methodParams = new Object[]{};
    private Object newedObject = new Object();

    public void setupSubjects() {
        subject = new NewerInvocationHandler(pebbleProvider, implClass);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(pebbleProvider, newedObject, "provide", implClass, methodParams);
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(newedObject, actualObject);
    }
}
