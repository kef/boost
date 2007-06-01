package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// FIX 1977 Even simpler...  An object referencing itself.  Implement as separate test case.
public final class SimpleCyclicDependenciesDemoTest extends BoooostCase {
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler(GoodCitizen.class);
    private final Spider spider = spiderAssembler.assemble();
    private final Registry registry = spider;
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    {
        registry.multiple(Ball.class, DefaultBall.class);
        registry.multiple(Runner.class, DefaultRunner.class);
    }

    public void testDependencyWithTwoObjects() {
        checkResolveBall();
        checkResolveRunner();
    }

    private void checkResolveBall() {
        Ball ball = (Ball) spider.resolve(Ball.class);
        checkSet(ball, "runner");
    }

    private void checkResolveRunner() {
        Runner runner = (Runner) spider.resolve(Runner.class);
        checkSet(runner, "ball");
    }

    private void checkSet(Object ref, String fieldName) {
        Object value = fielder.getInstance(ref, fieldName);
        assertNotNull(value);
    }
}
