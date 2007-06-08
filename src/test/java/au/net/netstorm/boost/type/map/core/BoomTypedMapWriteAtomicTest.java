package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class BoomTypedMapWriteAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    TypedMapWrite subject;
    String key;
    String stringValue;
    Integer intValue;
    Boolean booleanValue;
    Long longValue;
    byte[] bytes;
    int[] ints;

    public void setupSubjects() {
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
    