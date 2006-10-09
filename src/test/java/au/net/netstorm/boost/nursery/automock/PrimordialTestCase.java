package au.net.netstorm.boost.nursery.automock;

import junit.framework.TestCase;

public class PrimordialTestCase extends TestCase {

    // FIX SC525 Wire in hook to delegates.
    // FIX SC525 Hook into the strategist.
    public void runBare() throws Throwable {
        // FIX SC525 init().
        try {
            super.runBare();
        } catch (Throwable throwable) {
            // FIX SC525 destroy.
        }
    }
}
