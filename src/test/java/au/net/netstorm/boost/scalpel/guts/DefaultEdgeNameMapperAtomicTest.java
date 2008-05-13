package au.net.netstorm.boost.scalpel.guts;

import au.net.netstorm.boost.gunge.string.StringTransform;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultEdgeNameMapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeNameMapper subject;
    EdgePackage edgesMock;
    StringTransform transformerMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeNameMapper();
        expect.oneCall(edgesMock, "foo", "prefix");
    }

    public void testStaticEdgeToReal() {
        expect.oneCall(transformerMock, "foo.X", "stripSuffix", "foo.XStatic", "Static");
        expect.oneCall(transformerMock, "X", "stripPrefix", "foo.X", "foo.");
        String result = subject.staticEdgeToReal("foo.XStatic");
        assertEquals("X", result);
    }

    public void testEdgeToReal() {
        expect.oneCall(transformerMock, "X", "stripPrefix", "foo.X", "foo.");
        String result = subject.edgeToReal("foo.X");
        assertEquals("X", result);
    }

    public void testRealToEdge() {
        String result = subject.realToEdge("X");
        assertEquals("foo.X", result);
    }

    public void testRealToStaticEdge() {
        String result = subject.realToStaticEdge("X");
        assertEquals("foo.XStatic", result);
    }
}
