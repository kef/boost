package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.ioc.BoostSpiderConfig;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.spider.core.Spider;

public class ImmutablesTest extends LifecycleTestCase {
    Spider spider = spider();

    // FIX 2130 --- (Coordinate with MH) Remove "dupe" with ResolverDemooooTest.
    private Spider spider() {
        SpiderEgg egg = new DefaultSpiderEgg();
        // FIX 2394 add an optional dependencies() method to config so Boost can be handled implicitly
        // FIX 2394 ideally, dependencies could be used to create multiple independent sub-spiders
        return egg.hatch(BoostSpiderConfig.class, ImmutablesConfig.class);
    }
}
