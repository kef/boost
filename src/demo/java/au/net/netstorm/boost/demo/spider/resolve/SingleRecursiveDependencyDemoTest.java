package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class SingleRecursiveDependencyDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry registry = spider;
    private final Resolver resolver = spider;

    {
        registry.multiple(Recursion.class, MrRecursion.class);
    }

    public void testXxx() {
        Recursion recursion = (Recursion) resolver.resolve(Recursion.class);
        // FIX 1977 Check the field equals the original object.
        // FIX BREADCRUMB 1977 QQQQQQQQQQQQQQQQQQQQQQ Complete me.
    }
}
