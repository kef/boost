package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultConstructorFilterAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private ConstructorFilter subject;
    ConstructorFixture fixture;
    FunctionalCollection collectionMock;
    ObjectToClassMapper mapperMock;
    Types typesMock;
    CompatibleSignaturesFilter compatMock;
    List<Class<?>> classesMock;
    List<Constructor<?>> ctorMock;

    // FIX 2328 The testing framework should do this for us!!!!
    public void setUpFixtures() {
        subject = new DefaultConstructorFilter();
    }

    public void testFilter() {
        List<?> vector = fixture.vector();
        expect.oneCall(collectionMock, classesMock, "map", new Object[]{vector}, mapperMock);
        expect.oneCall(typesMock, compatMock, "nu", CompatibleSignaturesFilter.class, classesMock);
        expect.oneCall(collectionMock, ctorMock, "filter", fixture.constructors(), compatMock);
        List<Constructor<?>> result = subject.filter(DualOverloadCtor.class, vector);
        assertEquals(ctorMock, result);
    }
}
