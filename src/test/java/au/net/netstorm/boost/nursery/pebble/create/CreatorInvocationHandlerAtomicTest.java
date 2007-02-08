package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class CreatorInvocationHandlerAtomicTest extends PrimordialTestCase implements UsesMocks {
    private InvocationHandler subject;
    private MockExpectations expect;
    private Creator creator;
    private Object proxyObject = new Object();
    private Object[] createMethodParameters = new Object[]{};
    private Object createdObject = new Object();

    public void setupSubjects() {
        subject = new CreatorInvocationHandler(creator);
    }

    public void testInvokeCreate() throws Throwable {
        Method createMethod = Object.class.getMethod("toString", null);
        Object methodReturnType = createMethod.getReturnType();
        expect.oneCall(creator, createdObject, "create", methodReturnType, createMethodParameters);
        Object actualObject = subject.invoke(proxyObject, createMethod, createMethodParameters);
        assertSame(createdObject, actualObject);
    }
}
