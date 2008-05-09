package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.net.URL;
import au.net.netstorm.boost.gunge.string.StringTransform;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultClassWarperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private static final String TEST_EDGE_PREFIX = "au.net.netstorm.boost.edge.testdata";
    private ClassWarper subject;
    EdgeClass classerMock;
    StringTransform transformerMock;
    EdgePackage edgesMock;
    Throwable cnfDummy;

    public void setUpFixtures() {
        subject = new DefaultClassWarper();
        cnfDummy = new ClassNotFoundException();
    }

    public void testEdgeToReal() {
        String edgeName = TEST_EDGE_PREFIX + ".java.net.URL";
        setExpectations(edgeName, java.net.URL.class);
        checkEdgeToReal(URL.class, java.net.URL.class, false);
    }

    public void testStaticEdgeToReal() {
        String edgeName = TEST_EDGE_PREFIX + ".java.lang.ClassStatic";
        String nonStaticEdgeName = TEST_EDGE_PREFIX + ".java.lang.Class";
        expect.oneCall(transformerMock, nonStaticEdgeName, "stripSuffix", edgeName, "Static");
        setExpectations(nonStaticEdgeName, Class.class);
        checkEdgeToReal(ClassStatic.class, Class.class, true);
    }

    private void setExpectations(String edgeName, Class<?> realClass) {
        String realName = realClass.getName();
        String striped = edgeName.replace(TEST_EDGE_PREFIX + ".", "");
        expect.oneCall(edgesMock, TEST_EDGE_PREFIX, "prefix");
        expect.oneCall(classerMock, realClass, "forName", realName);
        expect.oneCall(transformerMock, striped, "stripPrefix", edgeName, TEST_EDGE_PREFIX + ".");
    }

    private void checkEdgeToReal(Class<?> edgeClass, Class<?> realClass, boolean staticy) {
        Class<?> result = subject.edgeToReal(edgeClass, staticy);
        assertEquals(realClass, result);
    }
}
