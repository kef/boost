package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Constructor;

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
    Unedger unedgerMock;

    public void setUpFixtures() {
        subject = new DefaultTempMultiNu();
    }

    public void testNuGeneric() {
        expectations(fixture.vectorctor(), fixture.vector());
        subject.nu(DualOverloadCtor.class, fixture.vector());
    }

    public void testNuSpecific() {
        expectations(fixture.stackctor(), fixture.stack());
        subject.nu(DualOverloadCtor.class, fixture.stack());
    }

    private void expectations(Constructor<DualOverloadCtor> ctor, Object arg) {
        Object[] args = new Object[] {arg};
        expect.oneCall(unedgerMock, args, "unedge", new Object[] {args});
        expect.oneCall(resolverMock, ctor, "resolve", DualOverloadCtor.class, args);
        expect.oneCall(constructorMock, ctorMock, "newInstance", ctor, args);
    }
}
