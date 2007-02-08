package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class CreatorInvocationHandlerAtomicTest extends PrimordialTestCase implements UsesMocks {
    private InvocationHandler subject;
    private MockExpectations expect;
    private Creator creator;
    private Class implClass = DriverManager.class;
    private Object proxyObject = new Object();
    private Object[] methodParams = new Object[]{};
    private Object createdObject = new Object();

    public void setupSubjects() {
        subject = new CreatorInvocationHandler(creator, implClass);
    }

    public void testInvokeCreate() throws Throwable {
        Method method = Object.class.getMethod("wait", null);
        expect.oneCall(creator, createdObject, "create", implClass, methodParams);
        Object actualObject = subject.invoke(proxyObject, method, methodParams);
        assertSame(createdObject, actualObject);
    }
}
