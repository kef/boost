package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultTryFinallyHandlerAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinallyHandler subject;
    Knot knot;
    Apron apron;
    EdgeClass classer = new DefaultEdgeClass();
    Method tieMethod = getTieMethod();
    Object[] params;
    Integer result;
    Object irrelevant;
    TryFinally tryfinally;

    public void setupSubjects() {
        params = new Object[]{knot};
        subject = new DefaultTryFinallyHandler(apron, tryfinally);
    }

    // FIX 54976 1. Ensure in() is called.
    // FIX 54976 2. Ensure out() is called.
    // FIX 54976 3. Ensure out() is called even when an exception is thrown.
    // FIX 54976 Complete this test.
    public void testSomething() throws Throwable {
        expect.oneCall(tryfinally, VOID, "in");
        expect.oneCall(apron, result, "tie", knot);
        Object actual = subject.invoke(irrelevant, tieMethod, params);
//        assertEquals(result, actual);
    }

    private Method getTieMethod() {
        Class[] parameters = {Knot.class};
        return classer.getMethod(Apron.class, "tie", parameters);
    }
}
