package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;

public final class DefaultTryCatchFinallyHandlerAtomicTest extends InteractionTestCase implements LazyFields, HasFixtures {
    UnknownKnotException throwable = new UnknownKnotException();
    EdgeClass classer = new DefaultEdgeClass();
    Method tieMethod = getTieMethod();
    TryFinallyHandler subject;
    Knot knot;
    Apron apron;
    Object[] params;
    Integer result;
    Object irrelevant;
    TryCatchFinally tryfinally;

    public void setUpFixtures() {
        params = new Object[]{knot};
        subject = new DefaultTryCatchFinallyHandler(apron, tryfinally);
    }

    public void testNormal() throws Throwable {
        expect.oneCall(tryfinally, VOID, "theCore");
        expect.oneCall(apron, result, "tie", knot);
        expect.oneCall(tryfinally, VOID, "theFinally");
        Object actual = subject.invoke(irrelevant, tieMethod, params);
        assertEquals(result, actual);
    }

    public void testException() throws Throwable {
        expect.oneCall(tryfinally, VOID, "theCore");
        expect.oneCall(apron, throwable, "tie", knot);
        expect.oneCall(tryfinally, VOID, "theFinally");
        try {
            subject.invoke(irrelevant, tieMethod, params);
            fail();
        } catch (InvocationTargetException expected) {
            Throwable actual = expected.getTargetException();
            assertEquals(throwable, actual);
        }
    }

    private Method getTieMethod() {
        Class[] parameters = {Knot.class};
        return classer.getMethod(Apron.class, "tie", parameters);
    }
}
