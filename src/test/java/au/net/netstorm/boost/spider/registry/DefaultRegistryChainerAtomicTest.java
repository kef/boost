package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultRegistryChainerAtomicTest extends LifecycleTestCase implements InjectableTest {
    RegistryChainer subject;
    FieldTestUtil fielder;
    Registry registry;
    Resolver resolver;

    public void testChain() {
        subject.chain(registry, Athlete.class, TimedAthlete.class, DefaultAthlete.class);
        Olympics olympics = resolver.resolve(Olympics.class);
        checkHost(olympics);
    }

    private void checkHost(Olympics olympics) {
        Athlete athlete = (Athlete) fielder.getInstance(olympics, "athlete");
        assertEquals(true, athlete instanceof TimedAthlete);
        checkChain(athlete);
    }

    private void checkChain(Athlete athlete) {
        Athlete delegate = (Athlete) fielder.getInstance(athlete, "delegate");
        assertEquals(true, delegate instanceof DefaultAthlete);
    }
}