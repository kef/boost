package au.net.netstorm.boost.nursery.automock;

import junit.framework.TestCase;

public class PrimordialTestCase extends TestCase {
    private TestStrategy strategy;

    public void runBare() throws Throwable {
        init();
        try {
            super.runBare();
        } finally {
            destroy();
        }
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
