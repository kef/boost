package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultStampAtomicTest extends InteractionTestCase {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    ClassTestChecker classer = new DefaultClassTestChecker();
    String value;

    // FIX 2081 Ensure extends Primordial.
    // FIX 2081 Test barfs on nulls.
    public void testValue() {
        Stamp stamp = new DefaultStamp(value);
        Object actual = fielder.getInstance(stamp, "value");
        assertEquals(value, actual);
    }

    public void testCharacteristics() {
        classer.checkSubclassOf(DefaultStamp.class, Primordial.class);
    }

    public void testNullIntolerant() {
        try {
            new DefaultStamp(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
