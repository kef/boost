package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.test.automock.InteractionTestLifecycle;
import au.net.netstorm.boost.test.automock.MockExpectations;

// FIX 1524 Rename to something nicer.
public class StrategyTestCase extends BoooostCase {
    private TestLifecycle lifecycle = new InteractionTestLifecycle(this);
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
