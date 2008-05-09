package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.net.URL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultEdgeMapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeMapper subject;
    EdgeNameMapper mapperMock;
    EdgeClass classerMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeMapper();
    }

    public void testStaticEdgeToReal() {
        expects("staticEdgeToReal", ClassStatic.class, Class.class);
        Class<?> result = subject.staticEdgeToReal(ClassStatic.class);
        assertEquals(Class.class, result);
    }

    public void testEdgeToReal() {
        expects("edgeToReal", URL.class, java.net.URL.class);
        Class<?> result = subject.edgeToReal(URL.class);
        assertEquals(java.net.URL.class, result);
    }

    public void testRealToEdge() {
        expects("realToEdge", java.net.URL.class, URL.class);
        Class<?> result = subject.realToEdge(java.net.URL.class);
        assertEquals(URL.class, result);
    }

    private void expects(String method, Class<?> from, Class<?> to) {
        String edgeName = from.getName();
        expect.oneCall(mapperMock, "realname", method, edgeName);
        expect.oneCall(classerMock, to, "forName", "realname");
    }
}
