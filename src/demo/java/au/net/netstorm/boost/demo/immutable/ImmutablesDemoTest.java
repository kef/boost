package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.Spider;

public final class ImmutablesDemoTest extends LifecycleTestCase implements LazyFields {
    Spider spider = spider();

    public void testImmutables() {
        // FIX BREADCRUMB 2130 AAAAAAAAAAAAAAAAAAAA Complete.

//        fail();
    }

    // FIX 2130 Remove "dupe" with ResolverDemooooTest.
    private Spider spider() {
        SpiderEgg egg = new DefaultSpiderEgg();
        return egg.hatch(ImmutablesConfig.class);
    }
}
