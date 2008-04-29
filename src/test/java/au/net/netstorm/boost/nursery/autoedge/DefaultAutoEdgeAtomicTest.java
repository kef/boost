package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

// FIXME-MH this is not really an atomic test, the difference between BAIS and a mock is negligible,
//          but some of the other dependencies (warper) could be pulled out
public final class DefaultAutoEdgeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private EdgeClass classer = new DefaultEdgeClass();
    private AutoEdge<InputStream> subject;
    private Method unedge;
    EdgeFixture fixture;
    MethodWarp warper;

    public void setUpFixtures() {
        subject = new DefaultAutoEdge<InputStream>(fixture.stream(), warper);
        unedge = classer.getDeclaredMethod(Edge.class, "unedge");
    }

    public void testInvoke() {
        byte[] result = new byte[fixture.length()];
        Object[] args = { result };
        Object length = subject.invoke(fixture.stream(), fixture.read(), args);
        assertEquals(fixture.data(), result);
        assertEquals(true, length instanceof Integer);
        Integer i = (Integer) length;
        assertEquals(fixture.length(), i.intValue());
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
