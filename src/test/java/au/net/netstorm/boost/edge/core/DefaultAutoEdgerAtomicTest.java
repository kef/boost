package au.net.netstorm.boost.edge.core;

import java.io.ByteArrayInputStream;
import java.net.URL;

import au.net.netstorm.boost.edge.guts.ClassWarper;
import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.RealNu;
import au.net.netstorm.boost.edge.guts.StreamFixture;
import au.net.netstorm.boost.edge.guts.URLFixture;
import au.net.netstorm.boost.edge.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private AutoEdger subject;
    private StreamFixture stream;
    private URLFixture url;
    EdgeFactory edgerMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    ClassStatic classStaticMock;
    ClassWarper warperMock;
    RealNu realNuMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
        stream = new StreamFixture();
        url = new URLFixture();
    }

    public void testEdge() {
        expect.oneCall(edgerMock, inMock, "nu", AutoEdgeInputStream.class, ByteArrayInputStream.class, stream.real());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, stream.real());
        assertSame(inMock, result);
    }

    public void testStaticEdge() {
        expect.oneCall(warperMock, Class.class, "edgeToReal", ClassStatic.class);
        expect.oneCall(edgerMock, classStaticMock, "nu", ClassStatic.class, Class.class, null);
        ClassStatic result = subject.edge(ClassStatic.class);
        assertSame(classStaticMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(warperMock, URL.class, "edgeToReal", AutoEdgeURL.class);
        expect.oneCall(realNuMock, url.real(), "nu", URL.class, new Object[]{url.arg()});
        expect.oneCall(edgerMock, urlMock, "nu", AutoEdgeURL.class, URL.class, url.real());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, url.arg());
        assertSame(urlMock, result);
    }
}
