package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.JUnitLifecycle;

public class InteractionTestCase extends CleanTestCase implements UsesExpectations {
    private JUnitLifecycle lifecycle = new InteractionTest(this);
    public MockExpectations expect;

    public final void runBare() throws Throwable {
        try {
            lifecycle.pre();
            super.runTest();
            lifecycle.post();
        } finally {
            lifecycle.cleanup();
        }
    }
}
