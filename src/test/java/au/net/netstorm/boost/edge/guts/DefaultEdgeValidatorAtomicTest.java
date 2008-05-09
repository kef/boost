package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.testdata.java.lang.BadNamedEdge;
import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.net.URL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultEdgeValidatorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeValidator subject;
    EdgeNameMapper mapperMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeValidator();
    }

    public void testValidEdge() {
        expect.oneCall(mapperMock, "au.net.netstorm.boost.edge.testdata.java.net.URL", "realToEdge", "java.net.URL");
        subject.validate(URL.class, java.net.URL.class, false);
    }

    public void testValidStaticEdge() {
        expect.oneCall(mapperMock, "au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic", "realToStaticEdge", "java.lang.Class");
        subject.validate(ClassStatic.class, Class.class, true);
    }

    public void testInvalidNamedEdged() {
        expect.oneCall(mapperMock, "foo.does.not.Match", "realToEdge", "java.lang.Class");
        try {
            subject.validate(BadNamedEdge.class, Class.class, false);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
