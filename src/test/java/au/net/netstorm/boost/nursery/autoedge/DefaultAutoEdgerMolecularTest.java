package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultAutoEdgerMolecularTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject {
    private AutoEdger subject;
    EdgeFixture fixture;
    ProxySupplier proxier;
    AutoEdgeFactory factory;
    FieldTestUtil fielder;
    TempMultiNu nu;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        AutoEdgeInputStream edge = subject.edge(AutoEdgeInputStream.class, fixture.stream());
        byte[] result = new byte[fixture.length()];
        int length = edge.read(result);
        assertEquals(fixture.data(), result);
        assertEquals(fixture.length(), length);
    }

    public void testNewEdge() {
        AutoEdgeURL edge = subject.newEdge(AutoEdgeURL.class, URL.class, fixture.value());
        String result = edge.toString();
        assertEquals(fixture.value(), result);
    }

    public void testUnedge() {
        AutoEdgeInputStream edge = subject.edge(AutoEdgeInputStream.class, fixture.stream());
        InputStream result = edge.unedge();
        assertSame(fixture.stream(), result);
    }

    public void testNewUnedge() {
        AutoEdgeURL edge = subject.newEdge(AutoEdgeURL.class, URL.class, fixture.value());
        URL url = edge.unedge();
        assertEquals(fixture.url(), url);
    }
}
