package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;

import au.net.netstorm.boost.edge.java.io.EdgeInputStream;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultAutoEdgerMolecularTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private AutoEdger uut;
    EdgeFixture fixture;
    ProxySupplier proxier;
    AutoEdgeFactory factory;
    FieldTestUtil fielder;

    public void setUpFixtures() {
        uut = new DefaultAutoEdger();
        fielder.setInstance(uut, "proxier", proxier);
        fielder.setInstance(uut, "factory", factory);
    }

    public void testEdge() throws Throwable {
        EdgeInputStream edge = uut.edge(EdgeInputStream.class, fixture.stream());
        byte[] result = new byte[fixture.length()];
        int length = edge.read(result);
        assertEquals(fixture.data(), result);
        assertEquals(fixture.length(), length);
    }

    public void testUnedge() throws Throwable {
        EdgeInputStream edge = uut.edge(EdgeInputStream.class, fixture.stream());
        InputStream result = uut.unedge(edge);
        assertSame(fixture.stream(), result);
    }
}
