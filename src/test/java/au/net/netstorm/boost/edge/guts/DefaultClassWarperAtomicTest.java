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
        setExpectations(URL.class, java.net.URL.class, false);
        checkEdgeToReal(URL.class, java.net.URL.class);
    }

    public void testStaticEdgeToReal() {
        setExpectations(ClassStatic.class, Class.class, true);
        checkEdgeToReal(ClassStatic.class, Class.class);
    }

    private void setExpectations(Class<?> edgeClass, Class<?> realClass, boolean stripSuffix) {
        String edgeName = edgeClass.getName();
        String realName = realClass.getName();
        String striped = edgeName.replace(TEST_EDGE_PREFIX + ".", "");
        if (stripSuffix)  expect.oneCall(transformerMock, realName, "stripSuffix", striped, "Static");
        expect.oneCall(edgesMock, TEST_EDGE_PREFIX, "prefix");
        expect.oneCall(classerMock, realClass, "forName", realName);
        expect.oneCall(transformerMock, striped, "stripPrefix", edgeName, TEST_EDGE_PREFIX + ".");
    }

    private void checkEdgeToReal(Class<?> edgeClass, Class<?> realClass) {
        Class<?> result = subject.edgeToReal(edgeClass);
        assertEquals(realClass, result);
    }
}
