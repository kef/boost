package au.net.netstorm.boost.gunge.collection;

import java.util.HashSet;
import java.util.Set;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultSetCreatorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Creator subject;

    public void setUpFixtures() {
        subject = new SetCreator();
    }

    public void testCreate() {
        Set expected = new HashSet();
        Object actual = subject.apply(new Object());
        assertEquals(expected, actual);
    }
}