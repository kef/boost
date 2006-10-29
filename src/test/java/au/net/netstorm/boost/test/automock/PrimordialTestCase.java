package au.net.netstorm.boost.test.automock;

import junit.framework.TestCase;

public class PrimordialTestCase extends TestCase {
    private TestStrategy strategy;

    public void runBare() throws Throwable {
        init();
        try {
            super.runBare();
            // FIX SC525 Incorporate or remove.
            verify();
        } finally {
            destroy();
        }
    }

    protected final void setUp() {
    }

    protected final void tearDown() {
    }

    private void init() {
        TestStrategist strategist = new DefaultTestStrategist();
        strategy = strategist.determineStrategy(this);
        strategy.init();
    }

    private void verify() {
        strategy.verify();
    }

    private void destroy() {
        strategy.destroy();
    }
}
