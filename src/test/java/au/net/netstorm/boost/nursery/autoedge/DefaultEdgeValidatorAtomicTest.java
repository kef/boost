package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.nursery.autoedge.testdata.bad.pack.Arrays;
import au.net.netstorm.boost.nursery.autoedge.testdata.java.lang.BadNamedEdge;
import au.net.netstorm.boost.nursery.autoedge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.nursery.autoedge.testdata.java.net.URL;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultEdgeValidatorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeValidator subject;
    TypeTokenResolver typeResolverMock;
    TypeTokenInstance typeInstanceMock;

    public void setUpFixtures() {
        subject = new DefaultEdgeValidator();
    }

    public void testValidEdge() {
        expectations(Edge.class, URL.class, java.net.URL.class);
        subject.validate(URL.class);
    }

    public void testValidStaticEdge() {
        expectations(StaticEdge.class, ClassStatic.class, Class.class);
        subject.validate(ClassStatic.class);
    }

    public void testInvalidPackagedEdged() {
        expectations(Edge.class, Arrays.class, java.util.Arrays.class);
        try {
            subject.validate(Arrays.class);
            fail();
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    public void testInvalidNamedEdged() {
        expectations(Edge.class, BadNamedEdge.class, Class.class);
        try {
            subject.validate(BadNamedEdge.class);
            fail();
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    private void expectations(Class<?> edgeType, Class<?> edgeClass, Class<?> realClass) {
        expect.oneCall(typeResolverMock, typeInstanceMock, "resolve", edgeType, edgeClass);
        expect.oneCall(typeInstanceMock, realClass, "rawType");
    }
}
