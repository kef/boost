package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.net.URL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultEdgeTypeAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    private static final String TEST_EDGE_PREFIX = "au.net.netstorm.boost.edge.testdata";
    private EdgeType subject;
    EdgePackage edgesMock;

    public void testEdge() {
        expect.oneCall(edgesMock, TEST_EDGE_PREFIX, "prefix");
        subject = new DefaultEdgeType(URL.class, java.net.URL.class, false, edgesMock);
        checkEdgeType(URL.class, java.net.URL.class, false);
    }

    public void testStaticEdge() {
        expect.oneCall(edgesMock, TEST_EDGE_PREFIX, "prefix");
        subject = new DefaultEdgeType(ClassStatic.class, Class.class, true, edgesMock);
        checkEdgeType(ClassStatic.class, Class.class, true);
    }

    public void testEdgeBadPrefix() {
        expect.oneCall(edgesMock, "bad", "prefix");
        try {
            new DefaultEdgeType(URL.class, java.net.URL.class, false, edgesMock);
        } catch (IllegalArgumentException expected) {}
    }

    public void testEdgeNull() {
        try {
            new DefaultEdgeType(null, java.net.URL.class, false, edgesMock);
        } catch (IllegalArgumentException expected) {}
    }

    public void testRealNull() {
        try {
            new DefaultEdgeType(URL.class, null, false, edgesMock);
        } catch (IllegalArgumentException expected) {}
    }

    private void checkEdgeType(Class<?> edge, Class<?> real, boolean staticy) {
        assertEquals(edge, subject.getEdge());
        assertEquals(real, subject.getReal());
        assertEquals(staticy, subject.isStaticEdge());
    }
}
