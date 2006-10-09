package au.net.netstorm.boost.nursery.automock;

import junit.framework.TestCase;

public class PrimordialTestCase extends TestCase {

    // FIX SC525 Wire in hook to delegates.
    public void runBare() throws Throwable {
        init();
        try {
            super.runBare();
        } finally {
            destroy();
            // FIX SC525 destroy.
        }
    }

    private void init() {
        // FIX SC525 Hook into the strategist.
    }

    private void destroy() {
        // FIX SC525 cleanup.
    }
}
