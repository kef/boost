package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.spider.core.Spider;

// FIX BREADCRUMB 2394 using to transition to the nu spider implementation for some demo tests.
// FIX 2394 This is a marker for tests that the nu spider does not handle.
public class ResolverDemooooTransitionTest extends ResolverDemooooTest {
    Spider nuSpider() {
        BoostSpiderBuilder spiderBuilder = new DefaultBoostSpiderBuilder();
        return spiderBuilder.build();
    }
}