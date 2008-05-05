package au.net.netstorm.boost.nursery.autoedge;

import java.io.ByteArrayInputStream;
import java.net.URL;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.nursery.autoedge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeStreamFixture;
import au.net.netstorm.boost.nursery.autoedge.testfixtures.EdgeURLFixture;
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

    TypeResolver typeResolverMock;
    TypeInstance typeInstanceMock;
    EdgeValidator validatorMock;
    ProxySupplier proxierMock;
    AutoEdge edgeMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    ClassStatic classStaticMock;
    RealNu realNuMock;
    Nu nuMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        edgeExpectations(ByteArrayInputStream.class, AutoEdgeInputStream.class, inMock, streamFixture.stream());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, streamFixture.stream());
        assertSame(inMock, result);
    }

    public void testStaticEdge() {
        expect.oneCall(typeResolverMock, typeInstanceMock, "resolve", ClassStatic.class, new Object[]{StaticEdge.class});
        expect.oneCall(typeInstanceMock, Class.class, "raw");
        edgeExpectations(Class.class, ClassStatic.class, classStaticMock, null);
        ClassStatic result = subject.edge(ClassStatic.class);
        assertSame(classStaticMock, result);
    }

    public void testNewEdge() {
        expect.oneCall(realNuMock, urlFixture.url(), "nu", AutoEdgeURL.class, new Object[]{urlFixture.value()});
        edgeExpectations(URL.class, AutoEdgeURL.class, urlMock, urlFixture.url());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, urlFixture.value());
        assertSame(urlMock, result);
    }

    private void edgeExpectations(Class<?> rawClass, Class<?> edgeClass, Object proxy, Object real) {
        Object[] args = {rawClass, real};
        Class<?>[] types = {edgeClass};
        ClassLoader loader = edgeClass.getClassLoader();
        expect.oneCall(nuMock, edgeMock, "nu", DefaultAutoEdge.class, args);
        expect.oneCall(proxierMock, proxy, "getProxy", loader, types, edgeMock);
        expect.oneCall(validatorMock, VOID, "validate", edgeClass, rawClass);
    }
}

