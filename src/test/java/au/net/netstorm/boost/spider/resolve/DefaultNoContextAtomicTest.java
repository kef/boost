package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultNoContextAtomicTest extends InteractionTestCase {

    // FIX 74285 Is this what we want to do to test this bad boy?
    public void testNoContext() {
        NoContext actual = new NoContext();
        assertNotNull(actual);
    }
}
