package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultConstructorFilterAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private ConstructorFilter subject;
    ConstructorFixture fixture;
    FunctionalCollection collectionMock;
    Object2ClassMapper mapperMock;
    Nu nuMock;
    CompatibleSignaturesFilter compatMock;
    List<Class<?>> classesMock;
    List<Constructor<?>> ctorMock;

    public void setUpFixtures() {
        subject = new DefaultConstructorFilter();
    }

    public void testFilter() {
        expect.oneCall(collectionMock, classesMock, "map", new Object[] { fixture.vector() }, mapperMock);
        expect.oneCall(nuMock, compatMock, "nu", DefaultCompatibleSignaturesFilter.class, new Object[] { classesMock });
        expect.oneCall(collectionMock, ctorMock, "filter", fixture.constructors(), compatMock);

        List<Constructor<?>> result = subject.filter(DualOverloadCtor.class, fixture.vector());

        assertEquals(ctorMock, result);
    }
}
