package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.testdata.bad.pack.Arrays;
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
    EdgePackage edgesMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeValidator();
    }

    public void testValidEdge() {
        expectTestDataPrefix();
        subject.validate(URL.class, java.net.URL.class);
    }

    public void testValidStaticEdge() {
        expectTestDataPrefix();
        subject.validate(ClassStatic.class, Class.class);
    }

    public void testInvalidPackagedEdged() {
        expectTestDataPrefix();
        try {
            subject.validate(Arrays.class, java.util.Arrays.class);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testInvalidNamedEdged() {
        try {
            subject.validate(BadNamedEdge.class, Class.class);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void expectTestDataPrefix() {
        expect.oneCall(edgesMock, "au.net.netstorm.boost.edge.testdata", "prefix");
    }

}
