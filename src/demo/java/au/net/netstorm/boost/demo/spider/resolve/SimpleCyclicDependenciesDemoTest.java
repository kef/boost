package au.net.netstorm.boost.demo.spider.resolve;

public final class SimpleCyclicDependenciesDemoTest extends ResolverDemooooTest {
    {
        registry.multiple(Ball.class, DefaultBall.class);
        registry.multiple(Runner.class, DefaultRunner.class);
    }

    public void testDependencyWithTwoObjects() {
        checkResolveBall();
        checkResolveRunner();
    }

    private void checkResolveBall() {
        Ball ball = resolver.resolve(Ball.class);
        checkSet(ball, "runner");
    }

    private void checkResolveRunner() {
        Runner runner = resolver.resolve(Runner.class);
        checkSet(runner, "ball");
    }

    private void checkSet(Object ref, String fieldName) {
        Object value = grapher.get(ref, fieldName);
        assertNotNull(value);
    }
}
