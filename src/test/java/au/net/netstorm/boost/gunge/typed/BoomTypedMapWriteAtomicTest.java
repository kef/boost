package au.net.netstorm.boost.gunge.typed;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX BREADCRUMB 8888 Tidy
public final class BoomTypedMapWriteAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    TypedMapWrite subject;
    String key;
    String stringValue;
    Integer intValue;
    Boolean booleanValue;
    Long longValue;
    byte[] bytes;
    Integer[] ints;

    public void setUpFixtures() {
        subject = new BoomTypedMapWrite();
    }

    public void testPutStringBarfs() {
        try {
            subject.put(key, stringValue);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    public void testPutIntBarfs() {
        try {
            subject.put(key, intValue);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    public void testPutBooleanBarfs() {
        try {
            subject.put(key, booleanValue);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    public void testPutLongBarfs() {
        try {
            subject.put(key, longValue);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    public void testPutBytesBarfs() {
        try {
            subject.put(key, bytes);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }

    public void testPutIntsBarfs() {
        try {
            subject.put(key, ints);
            fail();
        } catch (UnsupportedOperationException expected) { }
    }
}
