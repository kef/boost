package au.net.netstorm.boost.demo.immutable;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.Spider;

public final class ImmutablesDemoTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    Spider spider = spider();
    Worker worker;

    public void setUpFixtures() {
        worker = spider.resolve(Worker.class);
    }

    public void testEquality() {
        Work w1 = worker.work();
        Work w2 = worker.work();
        assertEquals(true, w1 != w2);
        assertEquals(w1, w2);
    }

    public void testString() {
        Work work = worker.work();
        assertEquals(string(), "" + work);
    }

    private String string() {
        return "Work[" + LINE +
                "    host=Host[doggdot.us]" + LINE +
                "    port=Port[8081]" + LINE +
                "]";
    }

    // FIX 2130 Hide this away.
    // FIX 2130 Remove "dupe" with ResolverDemooooTest.
    private Spider spider() {
        SpiderEgg egg = new DefaultSpiderEgg();
        return egg.hatch(ImmutablesConfig.class);
    }
}
