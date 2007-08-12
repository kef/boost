package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultStampAtomicTest extends InteractionTestCase {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    String value;

    // FIX 2081 Ensure extends Primordial.
    // FIX 2081 Test barfs on nulls.
    public void testValue() {
        Stamp stamp = new DefaultStamp(value);
        Object actual = fielder.getInstance(stamp, "value");
        assertEquals(value, actual);
    }
}
