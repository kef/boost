package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.testdata.java.net.URL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultClassWarperAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private ClassWarper subject;
    EdgeClass classerMock;
    EdgePackage edgesMock;
    Throwable cnfDummy;

    public void setUpFixtures() {
        subject = new DefaultClassWarper();
        cnfDummy = new ClassNotFoundException();
    }

    public void testEdgeToReal() {
        expect.oneCall(edgesMock, "au.net.netstorm.boost.edge.testdata", "prefix");
        expect.oneCall(classerMock, java.net.URL.class, "forName", "java.net.URL");
        Class<?> result = subject.edgeToReal(URL.class);
        assertEquals(java.net.URL.class, result);
    }

    public void testEdgeToRealFailWithBadPackage() {
        expect.oneCall(edgesMock, "bad.package", "prefix");
        try {
            subject.edgeToReal(URL.class);
        } catch (IllegalArgumentException expected) {}
    }

    public void testEdgeToRealFailWithClassNotFound() {
        expect.oneCall(edgesMock, "au.net.netstorm.boost.edge.testdata", "prefix");
        expect.oneCall(classerMock, new EdgeException(cnfDummy), "forName", "java.net.URL");
        try {
            subject.edgeToReal(URL.class);
        } catch (IllegalArgumentException expected) {}
    }
}
