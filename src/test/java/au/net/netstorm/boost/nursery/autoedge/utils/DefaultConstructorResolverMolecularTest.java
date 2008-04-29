package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultConstructorResolverMolecularTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    ConstructorResolver subject;
    ConstructorFixture fixture;

    public void testResolveGenericType() {
        Constructor<DualOverloadCtor> result = subject.resolve(DualOverloadCtor.class, fixture.vector());
        assertEquals(fixture.vectorctor(), result);
    }

    public void testResolveSpecificType() {
        Constructor<DualOverloadCtor> result = subject.resolve(DualOverloadCtor.class, fixture.stack());
        assertEquals(fixture.stackctor(), result);
    }
}
