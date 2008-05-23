package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.gunge.collection.FunctionalCollection;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultConstructorFilterAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    ConstructorFilter subject;
    ConstructorFixture fixture;
    FunctionalCollection collectionMock;
    ObjectToClassMapper mapperMock;
    Nu nuMock;
    CompatibleSignaturesFilter compatMock;
    List<Class<?>> classesMock;
    List<Constructor<?>> ctorMock;

    public void testFilter() {
        List<?> vector = fixture.vector();
        expect.oneCall(collectionMock, classesMock, "map", new Object[]{vector}, mapperMock);
        expect.oneCall(nuMock, compatMock, "nu", CompatibleSignaturesFilter.class, new Object[] {classesMock});
        expect.oneCall(collectionMock, ctorMock, "filter", fixture.constructors(), compatMock);
        List<Constructor<?>> result = subject.filter(DualOverloadCtor.class, vector);
        assertEquals(ctorMock, result);
    }
}
