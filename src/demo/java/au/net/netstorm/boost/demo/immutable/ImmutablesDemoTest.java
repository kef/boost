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
    Socker socker;

    public void setUpFixtures() {
        socker = spider.resolve(Socker.class);
    }

    public void testEquality() {
        Sock s1 = socker.sock();
        Sock s2 = socker.sock();
        assertEquals(true, s1 != s2);
        assertEquals(s1, s2);
    }

    public void testString() {
        Sock sock = socker.sock();
        assertEquals(string(), "" + sock);
    }

    private String string() {
        return "Sock[" + LINE +
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
