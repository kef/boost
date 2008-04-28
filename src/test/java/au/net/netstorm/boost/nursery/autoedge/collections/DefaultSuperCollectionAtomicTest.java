package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;
import java.util.Collections;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultSuperCollectionAtomicTest extends LifecycleTestCase implements InjectableTest, InjectableSubject, LazyFields {
    SuperCollection subject;
    IterableMaster iterableMock;
    Filter<String> filterMock;
    Mapper<String,String> mapperMock;
    CollectionFixture fixture;

    public void testFilterAll() {
        expect.manyCalls(filterMock, true, "accept", fixture.element());
        Collection<String> result = subject.filter(fixture.collection(), filterMock);
        assertEquals(fixture.collection(), result);
    }

    public void testFilterNone() {
        expect.manyCalls(filterMock, false, "accept", fixture.element());
        Collection<String> result = subject.filter(fixture.collection(), filterMock);
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testMap() {
        expect.manyCalls(mapperMock, fixture.mappedElement(), "map", fixture.element());
        Collection<String> result = subject.map(fixture.collection(), mapperMock);
        assertEquals(fixture.mappedCollection(), result);
    }
}
