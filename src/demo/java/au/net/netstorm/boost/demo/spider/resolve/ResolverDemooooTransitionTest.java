package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.spider.core.Spider;

// FIX BREADCRUMB 2394 using to transition to the nu spider implementation for some demo tests.
public class ResolverDemooooTransitionTest extends ResolverDemooooTest {
    Spider nuSpider() {
           SpiderEgg egg = new DefaultSpiderEgg();
           return egg.hatch();
    }
}