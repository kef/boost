package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultTryCatchFinallyHandlerAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    UnknownKnotException throwable = new UnknownKnotException();
    EdgeClass classer = new DefaultEdgeClass();
    Method tieMethod = getTieMethod();
    TryFinallyHandler subject;
    Knot knot;
    Apron apronMock;
    Object[] params;
    Integer result;
    Object irrelevant;
    TryCatchFinally tryfinallyMock;

    public void setUpFixtures() {
        params = new Object[]{knot};
        subject = new DefaultTryCatchFinallyHandler(apronMock, tryfinallyMock);
    }

    public void testNormal() throws Throwable {
        expect.oneCall(tryfinallyMock, VOID, "theCore");
        expect.oneCall(apronMock, result, "tie", knot);
        expect.oneCall(tryfinallyMock, VOID, "theFinally");
        Object actual = subject.invoke(irrelevant, tieMethod, params);
        assertEquals(result, actual);
    }

    public void testException() throws Throwable {
        expect.oneCall(tryfinallyMock, VOID, "theCore");
        expect.oneCall(apronMock, throwable, "tie", knot);
        expect.oneCall(tryfinallyMock, VOID, "theFinally");
        try {
            subject.invoke(irrelevant, tieMethod, params);
            fail();
        } catch (Exception actual) {
            assertEquals(throwable, actual);
        }
    }

    private Method getTieMethod() {
        Class[] parameters = {Knot.class};
        return classer.getMethod(Apron.class, "tie", parameters);
    }
}
