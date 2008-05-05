package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultImplementationRefAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Implementation implDummy;
    ImplementationRef subject;

    public void setUpFixtures() {
        subject = new DefaultImplementationRef(implDummy);
    }

    public void testGet() {
        Implementation actual = subject.get();
        assertEquals(implDummy, actual);
    }

    public void testExists() {
        checkExistsTrue();
        checkExistsFalse();
    }

    private void checkExistsTrue() {
        boolean actual = subject.exists();
        assertEquals(true, actual);
    }

    private void checkExistsFalse() {
        subject = new DefaultImplementationRef(null);
        boolean actual = subject.exists();
        assertEquals(false, actual);
    }
}
