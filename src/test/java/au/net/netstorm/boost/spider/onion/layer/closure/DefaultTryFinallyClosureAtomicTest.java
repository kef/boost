package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultTryFinallyClosureAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    UnknownKnotException throwable = new UnknownKnotException();
    TryFinallyClosure subject;
    TryFinally trierMock;
    Method methodMock;
    Object[] params;
    Apron apronMock;
    Integer result;

    public void setUpFixtures() {
        subject = new DefaultTryFinallyClosure(apronMock, trierMock);
    }

    public void testNormal() throws Throwable {
        expect.oneCall(trierMock, VOID, "theCore");
        expect.oneCall(methodMock, result, "invoke", apronMock, params);
        expect.oneCall(trierMock, VOID, "theFinally");
        Object actual = subject.invoke(methodMock, params);
        assertEquals(result, actual);
    }

    public void testException() throws Throwable {
        expect.oneCall(trierMock, VOID, "theCore");
        expect.oneCall(methodMock, throwable, "invoke", apronMock, params);
        expect.oneCall(trierMock, VOID, "theFinally");
        try {
            subject.invoke(methodMock, params);
            fail();
        } catch (Exception actual) {
            assertEquals(throwable, actual);
        }
    }
}
