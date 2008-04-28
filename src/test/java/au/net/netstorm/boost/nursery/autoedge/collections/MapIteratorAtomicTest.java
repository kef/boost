package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Iterator;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class MapIteratorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MapperIterator<String,String> uut;
    CollectionFixture fixture;
    IteratorUnsupportedRemoveChecker removeChecker;
    Mapper<String, String> mapperMock;

    public void setUpFixtures() {
        uut = new MapperIterator<String,String>(fixture.collection(), mapperMock);
    }

    public void testIterationAndMap() {
        expect.manyCalls(mapperMock, fixture.mappedElement(), "map", fixture.element());
        verifyEachElement();
    }

    public void testRemove() {
        removeChecker.checkIterationRemoveUnsupported(uut);
    }

    private void verifyEachElement() {
        while (uut.hasNext() && fixture().hasNext()) {
            String result = uut.next();
            String expected = fixture().next();
            assertEquals(expected, result);
        }
        assertEquals(fixture().hasNext(), uut.hasNext());
    }

    private Iterator<String> fixture() {
        return fixture.mappedIterator();
    }
}
