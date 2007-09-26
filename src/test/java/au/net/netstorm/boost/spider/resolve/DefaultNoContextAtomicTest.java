package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultNoContextAtomicTest extends InteractionTestCase {

    public void testNoContext() {
        NoContext actual = new NoContext();
        assertNotNull(actual);
    }
}
