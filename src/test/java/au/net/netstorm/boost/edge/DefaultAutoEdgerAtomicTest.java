package au.net.netstorm.boost.edge;

import java.io.ByteArrayInputStream;
import java.net.URL;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.edge.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.edge.testdata.AutoEdgeURL;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private AutoEdger subject;

    private StreamFixture stream;
    private URLFixture url;

    TypeResolver typeResolverMock;
    TypeInstance typeInstanceMock;
    EdgeValidator validatorMock;
    ProxySupplier proxierMock;
    AutoEdge edgeMock;
    AutoEdgeInputStream inMock;
    AutoEdgeURL urlMock;
    ClassStatic classStaticMock;
    RealNu realNuMock;
    Types typesMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
        stream = new StreamFixture();
        url = new URLFixture();
    }

    public void testEdge() {
        edgeExpectations(ByteArrayInputStream.class, AutoEdgeInputStream.class, inMock, stream.real());
        AutoEdgeInputStream result = subject.edge(AutoEdgeInputStream.class, stream.real());
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
        expect.oneCall(realNuMock, url.real(), "nu", AutoEdgeURL.class, new Object[]{url.arg()});
        edgeExpectations(URL.class, AutoEdgeURL.class, urlMock, url.real());
        AutoEdgeURL result = subject.nu(AutoEdgeURL.class, url.arg());
        assertSame(urlMock, result);
    }

    private void edgeExpectations(Class<?> rawClass, Class<?> edgeClass, Object proxy, Object real) {
        Object[] args = {rawClass, real};
        Class<?>[] types = {edgeClass, Unedgable.class};
        ClassLoader loader = edgeClass.getClassLoader();
        expect.oneCall(typesMock, edgeMock, "nu", AutoEdge.class, args);
        expect.oneCall(proxierMock, proxy, "getProxy", loader, types, edgeMock);
        expect.oneCall(validatorMock, VOID, "validate", edgeClass, rawClass);
    }
}

