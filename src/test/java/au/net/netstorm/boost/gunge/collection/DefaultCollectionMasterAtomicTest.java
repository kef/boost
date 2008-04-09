package au.net.netstorm.boost.gunge.collection;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultCollectionMasterAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    CollectionMaster subject;
    String[] array;

    public void setUpFixtures() {
        subject = new DefaultCollectionMaster();
    }

    public void testImmutables() {
        List list = subject.immutableList(array);
        checkImmutable(list);
        Set set = subject.immutableSet(array);
        checkImmutable(set);
    }

    public void testMutables() {
        List list = subject.mutableList(array);
        checkMutable(list);
        Set set = subject.mutableSet(array);
        checkMutable(set);
    }

    private void checkImmutable(Collection col) {
        try {
            col.remove(array[0]);
        } catch (UnsupportedOperationException expected) { }
    }

    private void checkMutable(Collection collection) {
        collection.remove(array[0]);
        assertEquals(false, collection.contains(array[0]));
    }
}