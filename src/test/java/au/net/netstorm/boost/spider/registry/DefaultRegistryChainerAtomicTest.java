package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.chain.Chain;
import au.net.netstorm.boost.spider.chain.DefaultChain;
import au.net.netstorm.boost.spider.resolve.Resolver;

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