package au.net.netstorm.boost.test.automock;

public class StrategyTestCase extends BoooostCase {
    private TestStrategy strategy;

    public void runBare() throws Throwable {
        init();
        try {
            super.runBare();
            verify();
        } finally {
            destroy();
        }
    }

    /**
     * Do not allow overriding of setup.  The test maintains the lifecycle.
     */
    protected void setup() {
    }

    /**
     * Do not allow overriding of setup.  The test maintains the lifecycle.
     */
    protected void teardown() {
    }

    /**
     * Do not use this when writing tests.  It is exposed only so we can test this infrastructure.
     */
    protected void verify() {
        strategy.verify();
    }

    private void init() {
        TestStrategist strategist = new DefaultTestStrategist();
        strategy = strategist.determineStrategy(this);
        strategy.init();
    }

    private void destroy() {
        strategy.destroy();
    }
}
