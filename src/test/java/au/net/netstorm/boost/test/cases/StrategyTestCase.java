package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.test.automock.InteractionTestLifecycle;
import au.net.netstorm.boost.test.automock.UsesMocks;

// FIX 1524 Rename to something nicer.
public class StrategyTestCase extends BoooostCase {
    // FIX 1524 Remove the cast.
    private TestLifecycle lifecycle = new InteractionTestLifecycle((UsesMocks) this);

    public void runBare() throws Throwable {
        lifecycle.initialise();
        try {
            super.runTest();
            verify();
        } finally {
            lifecycle.destroy();
        }
    }

    // FIX 1524 Close this off to private.
    protected void verify() {
        lifecycle.verify();
    }
}
