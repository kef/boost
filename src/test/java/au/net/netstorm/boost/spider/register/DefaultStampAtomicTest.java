package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.gunge.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.gunge.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.gunge.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.gunge.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.primordial.Primordial;

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
