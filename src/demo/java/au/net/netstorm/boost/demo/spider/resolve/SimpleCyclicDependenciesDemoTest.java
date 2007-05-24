package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.newer.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.newer.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// FIX 1971 Right package?
public final class SimpleCyclicDependenciesDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry registry = spider;
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    {
        registry.prototype(Ball.class, DefaultBall.class);
        registry.prototype(Runner.class, DefaultRunner.class);
    }

    public void testDependencyWithTwoObjects() {
//        checkOneWay();
//        checkTheOtherWay();
    }

    private void checkOneWay() {
        Ball ball = (Ball) spider.resolve(Ball.class);
        checkSet(ball, "runner");
    }

    private void checkTheOtherWay() {
        Runner runner = (Runner) spider.resolve(Runner.class);
        checkSet(runner, "ball");
    }

    private void checkSet(Object ref, String fieldName) {
        Object value = fielder.getInstance(ref, fieldName);
        assertNotNull(value);
    }

    // FIX BREADCRUMB 1971 Write multiple dependency test.
    // FIX BREADCRUMB 1971 Write test that depends on itself.
}
