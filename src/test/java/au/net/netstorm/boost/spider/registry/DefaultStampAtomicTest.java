package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

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
