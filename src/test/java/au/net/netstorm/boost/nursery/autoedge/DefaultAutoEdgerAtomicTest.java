package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;

import au.net.netstorm.boost.edge.java.io.EdgeInputStream;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAutoEdgerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private ClassLoader loader = EdgeInputStream.class.getClassLoader();
    private Class<?>[] proxyType = { EdgeInputStream.class, Edge.class };
    private AutoEdger subject;
    EdgeFixture fixture;
    ProxySupplier proxierMock;
    AutoEdgeFactory factoryMock;
    AutoEdge<?> edgeMock;
    EdgeInputStream inMock;

    public void setUpFixtures() {
        subject = new DefaultAutoEdger();
    }

    public void testEdge() {
        expect.oneCall(factoryMock, edgeMock, "newEdge", fixture.stream());
        expect.oneCall(proxierMock, inMock, "getProxy", loader, proxyType, edgeMock);
        EdgeInputStream result = subject.edge(EdgeInputStream.class, fixture.stream());
        assertSame(inMock, result);
    }

    public void testUnedge() {
        expect.oneCall(edgeMock, fixture.stream(), "unedge");
        InputStream result = subject.unedge(edgeMock);
        assertSame(fixture.stream(), result);
    }

    public void testUnedgeFailure() throws Throwable {
        try {
            subject.unedge("I am not an edged instance");
            fail("unedge of non-edge instance should fail");
        } catch (IllegalArgumentException e) { /* expected */ }
    }
}
