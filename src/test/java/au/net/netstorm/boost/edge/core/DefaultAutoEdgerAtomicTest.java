package au.net.netstorm.boost.edge.core;

import java.io.InputStream;
import java.net.URL;

import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.EdgeMapper;
import au.net.netstorm.boost.edge.guts.RealNu;
import au.net.netstorm.boost.edge.guts.StreamFixture;
import au.net.netstorm.boost.edge.guts.URLFixture;
import au.net.netstorm.boost.edge.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.util.ArrayList;
import au.net.netstorm.boost.edge.testdata.java.util.List;
import au.net.netstorm.boost.edge.testdata.java.util.UnedgableList;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private AutoEdger subject;
    StreamFixture stream;
    URLFixture url;
    EdgeFactory edgerMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    ClassStatic classStaticMock;
    EdgeMapper mapperMock;
    RealNu realNuMock;
    List<?> edgeListMock;
    java.util.List<?> realListMock;
    UnedgableList<?> unedgableListMock;
    UnedgableList<?> resultListMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        expect.oneCall(mapperMock, InputStream.class, "edgeToReal", AutoEdgeInputStream.class);
        expect.oneCall(edgerMock, inMock, "nu", AutoEdgeInputStream.class, InputStream.class, stream.real());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, stream.real());
        assertSame(inMock, result);
    }

    public void testCast() {
        expect.oneCall(mapperMock, java.util.ArrayList.class, "edgeToReal", ArrayList.class);
        expect.oneCall(edgerMock, resultListMock, "cast", ArrayList.class, java.util.ArrayList.class, unedgableListMock);
        UnedgableList<?> result = subject.cast(ArrayList.class, unedgableListMock);
        assertSame(resultListMock, result);
    }

    public void testStaticEdge() {
        expect.oneCall(mapperMock, Class.class, "staticEdgeToReal", ClassStatic.class);
        expect.oneCall(edgerMock, classStaticMock, "nu", ClassStatic.class, Class.class, null);
        ClassStatic result = subject.edge(ClassStatic.class);
        assertSame(classStaticMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(mapperMock, URL.class, "edgeToReal", AutoEdgeURL.class);
        expect.oneCall(realNuMock, url.real(), "nu", URL.class, new Object[]{url.arg()});
        expect.oneCall(edgerMock, urlMock, "nu", AutoEdgeURL.class, URL.class, url.real());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, url.arg());
        assertSame(urlMock, result);
    }

    public void testNeeEdge() {
        expect.oneCall(mapperMock, java.util.List.class, "edgeToReal", List.class);
        expect.oneCall(realNuMock, realListMock, "nu", java.util.ArrayList.class, new Object[]{5});
        expect.oneCall(edgerMock, edgeListMock, "nu", List.class, java.util.List.class, realListMock);
        List<?> result = subject.nee(List.class, java.util.ArrayList.class, 5);
        assertSame(edgeListMock, result);
    }
}

