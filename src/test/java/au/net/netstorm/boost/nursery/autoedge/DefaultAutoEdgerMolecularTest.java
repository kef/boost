package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdgerMolecularTest extends LifecycleTestCase implements HasFixtures, InjectableTest, InjectableSubject, LazyFields {
    private AutoEdger subject;

    EdgeURLFixture urlFixture;
    EdgeStreamFixture streamFixture;

    TypeTokenResolver typeResolver;
    ProxySupplier proxier;
    FieldTestUtil fielder;
    TempMultiNu multiNu;
    Nu nu;
    EdgeMethod invoker;
    MethodWarp warper;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        AutoEdgeInputStream edge = subject.edge(AutoEdgeInputStream.class, streamFixture.stream());
        byte[] result = new byte[streamFixture.length()];
        int length = edge.read(result);
        assertEquals(streamFixture.data(), result);
        assertEquals(streamFixture.length(), length);
    }

    public void testNewEdge() {
        AutoEdgeURL edge = subject.newEdge(AutoEdgeURL.class, urlFixture.value());
        String result = edge.toString();
        assertEquals(urlFixture.value(), result);
    }

    public void testUnedge() {
        AutoEdgeInputStream edge = subject.edge(AutoEdgeInputStream.class, streamFixture.stream());
        InputStream result = edge.unedge();
        assertSame(streamFixture.stream(), result);
    }

    public void testNewUnedge() {
        AutoEdgeURL edge = subject.newEdge(AutoEdgeURL.class, urlFixture.value());
        URL url = edge.unedge();
        assertEquals(urlFixture.url(), url);
    }
}
