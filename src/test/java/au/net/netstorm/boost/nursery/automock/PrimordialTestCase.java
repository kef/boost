package au.net.netstorm.boost.nursery.automock;

import junit.framework.TestCase;

public class PrimordialTestCase extends TestCase {
    private TestStrategy test;

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
        test = strategist.determineStrategy();
        test.init();
    }

    private void destroy() {
        test.destroy();
    }
}
