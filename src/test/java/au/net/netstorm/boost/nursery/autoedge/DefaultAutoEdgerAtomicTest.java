package au.net.netstorm.boost.nursery.autoedge;

import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private AutoEdger subject;

    EdgeStreamFixture streamFixture;
    EdgeURLFixture urlFixture;

    ProxySupplier proxierMock;
    AutoEdge<?> edgeMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    TempMultiNu multiNuMock;
    Nu nuMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        edgeExpectations(AutoEdgeInputStream.class, inMock, streamFixture.stream());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, streamFixture.stream());
        assertSame(inMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(multiNuMock, urlFixture.url(), "nu", URL.class, new Object[] { urlFixture.value() });
        edgeExpectations(AutoEdgeURL.class, urlMock, urlFixture.url());
        AutoEdgeURL result = subject.newEdge(AutoEdgeURL.class, URL.class, urlFixture.value());
        assertSame(urlMock, result);
    }

    private void edgeExpectations(Class<?> type, Object proxy, Object arg) {
        Class<?>[] types = { type };
        ClassLoader loader = type.getClassLoader();
        expect.oneCall(nuMock, edgeMock, "nu", DefaultAutoEdge.class, new Object[] { arg });
        expect.oneCall(proxierMock, proxy, "getProxy", loader, types, edgeMock);
    }
}
