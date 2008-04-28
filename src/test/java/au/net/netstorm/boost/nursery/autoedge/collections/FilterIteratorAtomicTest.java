package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class FilterIteratorAtomicTest extends LifecycleTestCase implements InjectableTest, InjectableSubject, LazyFields {
    private FilterIterator<String> uut;
    CollectionFixture fixture;
    IteratorUnsupportedRemoveChecker removeChecker;
    Filter<String> filterMock;

    public void testIterationAll() {
        expect.manyCalls(filterMock, true, "accept", fixture.element());
        Collection<String> result = collectResult();
        assertEquals(fixture.collection(), result);
    }

    public void testIterationNone() {
        expect.manyCalls(filterMock, false, "accept", fixture.element());
        Collection<String> result = collectResult();
        assertEquals(Collections.EMPTY_LIST, result);
    }

    public void testRemove() {
        expect.manyCalls(filterMock, true, "accept", fixture.element());
        uut = new FilterIterator<String>(fixture.collection(), filterMock);
        removeChecker.checkIterationRemoveUnsupported(uut);
    }

    private Collection<String> collectResult() {
        uut = new FilterIterator<String>(fixture.collection(), filterMock);
        Collection<String> result = new ArrayList<String>();
        while (uut.hasNext()) result.add(uut.next());
        return result;
    }
}
