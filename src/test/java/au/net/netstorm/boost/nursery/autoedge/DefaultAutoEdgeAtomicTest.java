package au.net.netstorm.boost.nursery.autoedge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdgeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdge<InputStream> subject;
    private Method unedge;
    EdgeClass classer = new DefaultEdgeClass();
    EdgeFixture fixture;
    MethodWarp warperMock;
    EdgeMethod invokerMock;
    Nu nu;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge<InputStream>(fixture.stream());
        unedge = classer.getDeclaredMethod(Edge.class, "unedge");
    }

    public void testInvoke() {
        byte[] result = new byte[fixture.length()];
        Object[] args = { result };
        expect.oneCall(warperMock, fixture.read(), "warp", ByteArrayInputStream.class, fixture.read());
        expect.oneCall(invokerMock, fixture.length(), "invoke", fixture.read(), fixture.stream(), args);
        Object length = subject.invoke(fixture.stream(), fixture.read(), args);
        assertEquals(fixture.length(), length);
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
