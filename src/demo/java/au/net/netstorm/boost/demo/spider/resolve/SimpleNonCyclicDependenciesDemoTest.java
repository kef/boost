package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class SimpleNonCyclicDependenciesDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final Registry web = spider;

    {
        web.prototype(Bicycle.class, BmxBicycle.class);
        web.prototype(Wheel.class, DefaultWheel.class);
    }

    // FIX BREADCRUMB 1971 Re-instate.
    public void testResolve() {
        Bicycle bicycle = (Bicycle) spider.resolve(Bicycle.class);
        Object o1 = fielder.getInstance(bicycle, "front");
        Object o2 = fielder.getInstance(bicycle, "rear");
        // FIX 1971 Reinstate.
        assertNotEquals(o1, o2);
    }
}
