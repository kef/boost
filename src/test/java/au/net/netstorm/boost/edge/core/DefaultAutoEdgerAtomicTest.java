package au.net.netstorm.boost.edge.core;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;

import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.EdgeMapper;
import au.net.netstorm.boost.edge.guts.EdgeValidator;
import au.net.netstorm.boost.edge.guts.RealNu;
import au.net.netstorm.boost.edge.guts.StreamFixture;
import au.net.netstorm.boost.edge.guts.URLFixture;
import au.net.netstorm.boost.edge.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.util.List;
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
    EdgeValidator validatorMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    ClassStatic classStaticMock;
    EdgeMapper mapperMock;
    RealNu realNuMock;
    List<?> edgeListMock;
    java.util.List<?> realListMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
        stream = new StreamFixture();
        url = new URLFixture();
    }

    public void testEdge() {
        expect.oneCall(validatorMock, VOID, "validate", AutoEdgeInputStream.class, ByteArrayInputStream.class, false);
        expect.oneCall(edgerMock, inMock, "nu", AutoEdgeInputStream.class, ByteArrayInputStream.class, stream.real());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, stream.real());
        assertSame(inMock, result);
    }

    public void testStaticEdge() {
        expect.oneCall(mapperMock, Class.class, "staticEdgeToReal", ClassStatic.class);
        expect.oneCall(validatorMock, VOID, "validate",  ClassStatic.class, Class.class, true);
        expect.oneCall(edgerMock, classStaticMock, "nu", ClassStatic.class, Class.class, null);
        ClassStatic result = subject.edge(ClassStatic.class);
        assertSame(classStaticMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(mapperMock, URL.class, "edgeToReal", AutoEdgeURL.class);
        expect.oneCall(validatorMock, VOID, "validate",  AutoEdgeURL.class, URL.class, false);
        expect.oneCall(realNuMock, url.real(), "nu", URL.class, new Object[]{url.arg()});
        expect.oneCall(edgerMock, urlMock, "nu", AutoEdgeURL.class, URL.class, url.real());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, url.arg());
        assertSame(urlMock, result);
    }

    public void testNewImplEdge() {
        expect.oneCall(validatorMock, VOID, "validate",  List.class, ArrayList.class, false);
        expect.oneCall(realNuMock, realListMock, "nu", ArrayList.class, new Object[]{5});
        expect.oneCall(edgerMock, edgeListMock, "nu", List.class, ArrayList.class, realListMock);
        List<?> result = subject.nuImpl(List.class, ArrayList.class, 5);
        assertSame(edgeListMock, result);
    }
}

