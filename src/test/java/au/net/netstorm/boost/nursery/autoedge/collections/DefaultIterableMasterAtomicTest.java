package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultIterableMasterAtomicTest extends LifecycleTestCase implements InjectableTest {
    IterableMaster uut;
    CollectionFixture fixture;

    public void testToIterable() throws Throwable {
        Iterable<String> iterable = uut.toIterable(fixture.iterator());
        assertSame(fixture.iterator(), iterable.iterator());
    }

    public void testToCollectionFromIterator() throws Throwable {
        Collection<String> collection = uut.toCollection(fixture.iterator());
        assertEquals(fixture.collection(), collection);
    }

    public void testToCollectionFromIterable() throws Throwable {
        Iterable<String> iterable = uut.toIterable(fixture.iterator());
        Collection<String> collection = uut.toCollection(iterable);
        assertEquals(fixture.collection(), collection);
    }
}
