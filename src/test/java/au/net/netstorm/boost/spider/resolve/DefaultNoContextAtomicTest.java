package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultNoContextAtomicTest extends LifecycleTestCase implements LazyFields {

    public void testNoContext() {
        NoContext actual = new NoContext();
        assertNotNull(actual);
    }
}
