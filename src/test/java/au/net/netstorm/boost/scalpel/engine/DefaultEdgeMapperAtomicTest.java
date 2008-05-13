package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.scalpel.testdata.java.net.URL;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.support.EdgeException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultEdgeMapperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private ClassNotFoundException cnfDummy;
    private EdgeMapper subject;
    EdgeNameMapper mapperMock;
    EdgeClass classerMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeMapper();
        cnfDummy = new ClassNotFoundException();
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

    public void testEdgeToRealFailure() {
        String edgeName = URL.class.getName();
        expect.oneCall(mapperMock, "badrealname", "edgeToReal", edgeName);
        expect.oneCall(classerMock, new EdgeException(cnfDummy), "forName", "badrealname");
        try {
            subject.edgeToReal(URL.class);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void expects(String method, Class<?> from, Class<?> to) {
        String edgeName = from.getName();
        expect.oneCall(mapperMock, "realname", method, edgeName);
        expect.oneCall(classerMock, to, "forName", "realname");
    }
}
