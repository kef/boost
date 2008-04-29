package au.net.netstorm.boost.nursery.autoedge;

import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private AutoEdger subject;
    EdgeFixture fixture;
    ProxySupplier proxierMock;
    AutoEdgeFactory factoryMock;
    AutoEdge<?> edgeMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    TempMultiNu nuMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        edgeExpectations(AutoEdgeInputStream.class, inMock, fixture.stream());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, fixture.stream());
        assertSame(inMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(nuMock, fixture.url(), "nu", URL.class, new Object[] { fixture.value() });
        edgeExpectations(AutoEdgeURL.class, urlMock, fixture.url());
        AutoEdgeURL result = subject.newEdge(AutoEdgeURL.class, URL.class, fixture.value());
        assertSame(urlMock, result);
    }

    private void edgeExpectations(Class<?> type, Object proxy, Object arg) {
        Class<?>[] types = { type };
        ClassLoader loader = type.getClassLoader();
        expect.oneCall(factoryMock, edgeMock, "newEdge", arg);
        expect.oneCall(proxierMock, proxy, "getProxy", loader, types, edgeMock);
    }
}
