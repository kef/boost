package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.nursery.autoedge.utils.ConstructorFixture;
import au.net.netstorm.boost.nursery.autoedge.utils.ConstructorResolver;
import au.net.netstorm.boost.nursery.autoedge.utils.DualOverloadCtor;
import au.net.netstorm.boost.nursery.autoedge.utils.OverloadCtor;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultTempMultiNuAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private TempMultiNu subject;
    ConstructorFixture fixture;
    ConstructorResolver resolverMock;
    EdgeConstructor constructorMock;
    OverloadCtor ctorMock;

    public void setUpFixtures() {
        subject = new DefaultTempMultiNu();
    }

    public void testNuGeneric() {
        expect.oneCall(resolverMock, fixture.vectorctor(), "resolve", DualOverloadCtor.class, new Object[] { fixture.vector() });
        expect.oneCall(constructorMock, ctorMock, "newInstance", fixture.vectorctor(), new Object[] { fixture.vector() });
        subject.nu(DualOverloadCtor.class, fixture.vector());
    }

    public void testNuSpecific() {
        expect.oneCall(resolverMock, fixture.stackctor(), "resolve", DualOverloadCtor.class, new Object[] { fixture.stack() });
        expect.oneCall(constructorMock, ctorMock, "newInstance", fixture.stackctor(), new Object[] { fixture.stack() });
        subject.nu(DualOverloadCtor.class, fixture.stack());
    }
}
