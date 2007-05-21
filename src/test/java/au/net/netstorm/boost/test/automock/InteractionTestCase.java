package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.TestLifecycle;

public class InteractionTestCase extends CleanTestCase implements UsesExpectations {
    private TestLifecycle lifecycle = new InteractionTest(this);
    public MockExpectations expect;

    public final void runBare() throws Throwable {
        lifecycle.initialise();
        try {
            super.runTest();
            lifecycle.verify();
        } finally {
            lifecycle.destroy();
        }
    }
}
