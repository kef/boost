package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.cases.TestLifecycle;

public class StrategyTestCase extends BoooostCase {
    private TestLifecycle lifecycle = new InteractionTest(this);
    public MockExpectations expect;

    public void runBare() throws Throwable {
        lifecycle.initialise();
        try {
            super.runTest();
            lifecycle.verify();
        } finally {
            lifecycle.destroy();
        }
    }
}
