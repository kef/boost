package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class ComplexNonCyclicDependenciesDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry web = spider;

    {
        web.prototype(Bicycle.class, BmxBicycle.class);
        web.prototype(Wheel.class, DefaultWheel.class);
    }

    // FIX BREADCRUMB 1971 Re-instate.
    public void testResolve() {
//        Bicycle bicycle = (Bicycle) spider.resolve(Bicycle.class);
//        Wheel frontWheel = bicycle.getFrontWheel();
//        Wheel rearWheel = bicycle.getRearWheel();
//        assertNotEquals(frontWheel, rearWheel);
    }
}
