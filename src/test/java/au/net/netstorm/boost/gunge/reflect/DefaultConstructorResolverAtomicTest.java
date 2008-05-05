package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultConstructorResolverAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private ConstructorResolver subject;
    ConstructorFixture fixture;
    ConstructorFilter filterMock;
    MostSpecificSignatureFinder finderMock;
    FunctionalCollection collectionMock;
    List<Constructor<?>> filteredMock;

    public void setUpFixtures() {
        subject = new DefaultConstructorResolver();
        expect.oneCall(filterMock, filteredMock, "filter", DualOverloadCtor.class, new Object[]{fixture.vector()});
    }

    public void testCanNotResolve() {
        expect.oneCall(filteredMock, 0, "size");
        try {
            subject.resolve(DualOverloadCtor.class, fixture.vector());
            fail("should not be able to resolve constructor");
        } catch (RuntimeException expected) { }
    }

    public void testResolveGenericType() {
        expect.oneCall(filteredMock, 1, "size");
        expect.oneCall(filteredMock, fixture.vectorctor(), "get", 0);
        Constructor<DualOverloadCtor> result = subject.resolve(DualOverloadCtor.class, fixture.vector());
        assertEquals(fixture.vectorctor(), result);
    }

    public void testResolveSpecificType() {
        expect.oneCall(filteredMock, 2, "size");
        expect.oneCall(collectionMock, fixture.stackctor(), "find", filteredMock, finderMock);
        Constructor<DualOverloadCtor> result = subject.resolve(DualOverloadCtor.class, fixture.stack());
        assertEquals(fixture.stackctor(), result);
    }
}
