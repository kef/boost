package au.net.netstorm.boost.pebble.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class NewerInvocationHandlerAtomicTest extends PrimordialTestCase implements UsesMocks {
    private InvocationHandler subject;
    private MockExpectations expect;
    private ObjectProvider objectProvider;
    private Class implClass = Random.class;
    private Object proxyObject = new Object();
    private Object[] methodParams = new Object[]{};
    private Object newedObject = new Object();

    public void setupSubjects() {
        subject = new NewerInvocationHandler(objectProvider, implClass);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(objectProvider, newedObject, "provide", implClass, methodParams);
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(newedObject, actualObject);
    }
}
