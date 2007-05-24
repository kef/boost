package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.newer.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.newer.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import junit.framework.TestCase;

// FIX 1971 Right package?
public final class DefaultCyclicDependenciesDemoAtomicTest extends TestCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry registry = spider;

    {
        registry.prototype(Ball.class, DefaultBall.class);
        registry.prototype(Runner.class, DefaultRunner.class);
    }

    // FIX BREADCRUMB 1971 Complete.
    public void testCyclicDependencies() {
        // FIX BREADCRUMB 1971 Re-instate.
//        spider.resolve(Ball.class);
    }
}
