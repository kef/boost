package au.net.netstorm.boost.gunge.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultFunctionalCollectionAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    FunctionalCollection subject;
    CollectionFixture fixture;
    Filter<String> filterMock;
    Mapper<String, String> mapperMock;
    Finder<String> finderMock;

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

    public void testFilterAllArray() {
        expect.manyCalls(filterMock, true, "accept", fixture.element());
        Collection<String> result = subject.filter(fixture.array(), filterMock);
        assertEquals(fixture.collection(), result);
    }

    public void testFilterNoneArray() {
        expect.manyCalls(filterMock, false, "accept", fixture.element());
        Collection<String> result = subject.filter(fixture.array(), filterMock);
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testMap() {
        expect.manyCalls(mapperMock, fixture.mappedElement(), "map", fixture.element());
        Collection<String> result = subject.map(fixture.collection(), mapperMock);
        assertEquals(fixture.mappedCollection(), result);
    }

    public void testMapArray() {
        expect.manyCalls(mapperMock, fixture.mappedElement(), "map", fixture.element());
        List<String> result = subject.map(fixture.array(), mapperMock);
        assertEquals(fixture.mappedCollection(), result);
    }

    public void testFind() {
        expect.manyCalls(finderMock, true, "next", fixture.element());
        checkFind();
    }

    public void testFindWithShortCircuit() {
        expect.oneCall(finderMock, false, "next", fixture.element());
        checkFind();
    }

    public void testFindArray() {
        expect.manyCalls(finderMock, true, "next", fixture.element());
        expect.oneCall(finderMock, fixture.element(), "result");
        String result = subject.find(fixture.array(), finderMock);
        assertEquals(fixture.element(), result);
    }

    private void checkFind() {
        expect.oneCall(finderMock, fixture.element(), "result");
        String result = subject.find(fixture.collection(), finderMock);
        assertEquals(fixture.element(), result);
    }
}
