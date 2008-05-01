package au.net.netstorm.boost.nursery.autoedge;

import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
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

    TypeTokenResolver typeResolverMock;
    ProxySupplier proxierMock;
    AutoEdge edgeMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    EdgeNu edgeNuMock;
    Nu nuMock;
    TypeTokenInstance typeTokenInstanceMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        edgeExpectations(AutoEdgeInputStream.class, inMock, streamFixture.stream());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, streamFixture.stream());
        assertSame(inMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(edgeNuMock, urlFixture.url(), "nu", URL.class, new Object[] { urlFixture.value() });
        expect.oneCall(typeResolverMock, typeTokenInstanceMock, "resolve", Edge.class, AutoEdgeURL.class);
        expect.oneCall(typeTokenInstanceMock, URL.class, "rawType");
        edgeExpectations(AutoEdgeURL.class, urlMock, urlFixture.url());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, urlFixture.value());
        assertSame(urlMock, result);
    }

    private void edgeExpectations(Class<?> type, Object proxy, Object arg) {
        Class<?>[] types = { type };
        ClassLoader loader = type.getClassLoader();
        expect.oneCall(nuMock, edgeMock, "nu", DefaultAutoEdge.class, new Object[] { arg });
        expect.oneCall(proxierMock, proxy, "getProxy", loader, types, edgeMock);
    }
}
