package au.net.netstorm.boost.edge.guts;

import java.io.InputStream;
import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge subject;
    private Method unedge;
    private Method toString;
    StreamFixture stream;
    MethodWarp warperMock;
    Unedger unedgerMock;
    EdgeMethod invokerMock;
    ReturnEdger returnEdgerMock;
    EdgeClass classer;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge(InputStream.class, stream.real());
        unedge = classer.getDeclaredMethod(Unedgable.class, "unedge");
        toString = classer.getDeclaredMethod(Object.class, "toString");
    }

    public void testInvoke() {
        byte[] result = new byte[stream.length()];
        Object[] args = {result};
        expectations(stream.edgeMethod(), stream.realMethod(), stream.length(), args);
        Object length = subject.invoke(stream.real(), stream.edgeMethod(), args);
        assertEquals(stream.length(), length);
    }

    public void testInvokeNoArgs() {
        String expected = "result";
        expectations(toString, toString, expected, null);
        Object result = subject.invoke(stream.real(), toString, null);
        assertEquals(expected, result);
    }

    public void testInvokeUnedge() {
        Object[] args = {};
        Object result = subject.invoke(null, unedge, args);
        assertEquals(true, result instanceof InputStream);
        assertSame(stream.real(), result);
    }

    public void testInvokeStatic() {
        String expected = "pretend toString is static";
        expectations(toString, toString, expected, null);
        Object result = subject.invoke(null, toString, null);
        assertEquals(expected, result);
    }

    private void expectations(Method src, Method trg, Object expected, Object args) {
        expect.oneCall(warperMock, trg, "warp", InputStream.class, src);
        expect.oneCall(unedgerMock, args, "unedge", args);
        expect.oneCall(invokerMock, expected, "invoke", trg, stream.real(), args);
        expect.oneCall(returnEdgerMock, expected, "edge", src, expected);
    }
}
