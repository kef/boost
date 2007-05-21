package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.cases.TestLifecycle;

public class InteractionTestCase extends BoooostCase implements UsesExpectations {
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

    protected final void setUp() throws Exception {
        boom();
    }

    protected final void tearDown() throws Exception {
        boom();
    }

    protected final void gearup() {
        boom();
    }

    protected final void geardown() {
        boom();
    }

    private void boom() {
        throw new UnsupportedOperationException("Use lifecycle provided by marker interfaces.");
    }
}
