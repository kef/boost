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

    /** Do not use this when writing tests.  It is exposed only so we can test this infrastructure. */
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
