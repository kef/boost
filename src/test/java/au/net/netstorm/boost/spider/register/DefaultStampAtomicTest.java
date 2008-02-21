package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultStampAtomicTest extends LifecycleTestCase implements LazyFields {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    ClassTestChecker classer = new DefaultClassTestChecker();
    String value;

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
