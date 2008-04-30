package au.net.netstorm.boost.nursery.autoedge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge<InputStream> subject;
    private Method unedge;
    private Method toString;
    EdgeClass classer;

    EdgeStreamFixture fixture;

    MethodWarp warperMock;
    EdgeMethod invokerMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge<InputStream>(fixture.stream());
        unedge = classer.getDeclaredMethod(Edge.class, "unedge");
        toString = classer.getDeclaredMethod(Object.class, "toString");
    }

    public void testInvoke() {
        byte[] result = new byte[fixture.length()];
        Object[] args = { result };
        expect.oneCall(warperMock, fixture.trg(), "warp", ByteArrayInputStream.class, fixture.src());
        expect.oneCall(invokerMock, fixture.length(), "invoke", fixture.trg(), fixture.stream(), args);
        Object length = subject.invoke(fixture.stream(), fixture.src(), args);
        assertEquals(fixture.length(), length);
    }

    public void testInvokeNoArgs() {
        String expected = "result";
        expect.oneCall(warperMock, toString, "warp", ByteArrayInputStream.class, toString);
        expect.oneCall(invokerMock, expected, "invoke", toString, fixture.stream(), null);
        Object result = subject.invoke(fixture.stream(), toString, null);
        assertEquals(expected, result);
    }

    public void testInvokeUnedge() {
        Object[] args = {};
        Object result = subject.invoke(null, unedge, args);
        assertEquals(true, result instanceof InputStream);
        assertSame(fixture.stream(), result);
    }

    public void testUnedge() {
        InputStream result = subject.unedge();
        assertSame(fixture.stream(), result);
    }
}
