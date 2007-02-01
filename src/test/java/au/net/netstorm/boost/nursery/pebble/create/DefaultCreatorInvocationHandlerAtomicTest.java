package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultCreatorInvocationHandlerAtomicTest extends PrimordialTestCase implements UsesMocks {
    private InvocationHandler subject;
    private MockExpectations expect;
    private Creator creator;
    private Object creatorObject = new Object();
    private Method dontCareMethod = Object.class.getMethods()[0];
    private Object[] createMethodParameters = new Object[]{};
    private Object createdObject = new Object();

    public void setupSubjects() {
        subject = new DefaultCreatorInvocationHandler(creator);
    }

    public void testInvokeCreate() throws Throwable {
        Class objectType = creatorObject.getClass();
        expect.oneCall(creator, createdObject, "create", objectType, createMethodParameters);
        Object actualObject = subject.invoke(creatorObject, dontCareMethod, createMethodParameters);
        assertSame(createdObject, actualObject);
    }
}
