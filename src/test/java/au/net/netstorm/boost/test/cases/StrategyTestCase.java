package au.net.netstorm.boost.test.cases;

public class StrategyTestCase extends BoooostCase {
    private TestStrategy strategy;

    public void runBare() throws Throwable {
        initialise();
        try {
            super.runBare();
            verify();
        } finally {
            destroy();
        }
    }

    protected void gearup() {
    }

    protected void geardown() {
    }

    protected void verify() {
        strategy.verify();
    }

    private void initialise() {
        TestStrategist strategist = new DefaultTestStrategist();
        strategy = strategist.determineStrategy(this);
        strategy.init();
    }

    private void destroy() {
        strategy.destroy();
    }
}
