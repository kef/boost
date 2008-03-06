package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.spider.chain.Chain;
import au.net.netstorm.boost.spider.chain.DefaultChain;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryChainerAtomicTest extends LifecycleTestCase implements InjectableTest, HasFixtures {
    private Chain chain;
    RegistryChainer subject;
    FieldTestUtil fielder;
    Registry registry;
    Resolver resolver;

    public void setUpFixtures() {
        Interface athlete = new DefaultInterface(Athlete.class);
        Implementation timed = new DefaultImplementation(TimedAthlete.class);
        Implementation defolt = new DefaultImplementation(DefaultAthlete.class);
        Implementation[] links = {timed, defolt};
        chain = new DefaultChain(athlete, links);
    }

    public void testChain() {
        subject.chain(registry, chain);
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