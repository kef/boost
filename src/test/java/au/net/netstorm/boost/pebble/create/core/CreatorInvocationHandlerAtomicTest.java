package au.net.netstorm.boost.pebble.create.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class CreatorInvocationHandlerAtomicTest extends PrimordialTestCase implements UsesMocks {
    private InvocationHandler subject;
    private MockExpectations expect;
    private ObjectProvider objectProvider;
    private Class implClass = Random.class;
    private Object proxyObject = new Object();
    private Object[] methodParams = new Object[]{};
    private Object createdObject = new Object();

    public void setupSubjects() {
        subject = new CreatorInvocationHandler(objectProvider, implClass);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(objectProvider, createdObject, "provide", implClass, methodParams);
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(createdObject, actualObject);
    }
}
