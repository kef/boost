package au.net.netstorm.boost.gunge.collection;

import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultArrayListCreatorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Creator subject;

    public void setUpFixtures() {
        subject = new ArrayListCreator();
    }

    public void testCreate() {
        List expected = new ArrayList();
        Object actual = subject.create(new Object());
        assertEquals(expected, actual);
    }
}
