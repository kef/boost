package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.test.automock.UsesExpectations;
import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;

public final class DefaultSuperMapAtomicTest extends InteractionTestCase implements HasSubjects, UsesExpectations, UsesAutoMocks {
    SuperMap subject;
    TypedMap typedMap;
    HolderMap holderMap;
    String key;
    String stringValue;
    Integer intValue;
    Boolean boolValue;
    byte[] bytesValue = "test".getBytes();
    int[] intsValue = {1, 2, 3};
    IntegerHolder intHolder;
    StringHolder stringHolder;
    BytesHolder bytesHolder;
    BooleanHolder booleanHolder;
    IntegerHolder[] intsHolder;
    LongHolder longHolder;
    Long longValue;

    public void setupSubjects() {
        subject = new DefaultSuperMap(typedMap, holderMap);
    }

    public void testGetString() {
        expect.oneCall(typedMap, stringValue, "getString", key);
        String actual = subject.getString(key);
        assertEquals(stringValue, actual);
    }

    public void testGetInt() {
        expect.oneCall(typedMap, intValue, "getInt", key);
        int actual = subject.getInt(key);
        int expected = intValue.intValue();
        assertEquals(expected, actual);
    }

    public void testGetLong() {
        expect.oneCall(typedMap, longValue, "getLong", key);
        long actual = subject.getLong(key);
        long expected = longValue.longValue();
        assertEquals(expected, actual);
    }

    public void testGetBoolean() {
        expect.oneCall(typedMap, boolValue, "getBoolean", key);
        boolean actual = subject.getBoolean(key);
        boolean expected = boolValue.booleanValue();
        assertEquals(expected, actual);
    }

    public void testGetBytes() {
        expect.oneCall(typedMap, bytesValue, "getBytes", key);
        byte[] actual = subject.getBytes(key);
        assertEquals(bytesValue, actual);
    }

    public void testGetInts() {
        expect.oneCall(typedMap, intsValue, "getInts", key);
        int[] actual = subject.getInts(key);
        assertEquals(intsValue, actual);
    }

    public void testGetIntHolder() {
        expect.oneCall(holderMap, intHolder, "getIntHolder", key);
        IntegerHolder actual = subject.getIntHolder(key);
        assertEquals(intHolder, actual);
    }

    public void testGetStringHolder() {
        expect.oneCall(holderMap, stringHolder, "getStringHolder", key);
        StringHolder actual = subject.getStringHolder(key);
        assertEquals(stringHolder, actual);
    }

    public void testGetBytesHolder() {
        expect.oneCall(holderMap, bytesHolder, "getBytesHolder", key);
        BytesHolder actual = subject.getBytesHolder(key);
        assertEquals(bytesHolder, actual);
    }

    public void testGetBooleanHolder() {
        expect.oneCall(holderMap, booleanHolder, "getBooleanHolder", key);
        BooleanHolder actual = subject.getBooleanHolder(key);
        assertEquals(booleanHolder, actual);
    }

    public void testGetIntsHolder() {
        expect.oneCall(holderMap, intsHolder, "getIntsHolder", key);
        IntegerHolder[] actual = subject.getIntsHolder(key);
        assertEquals(intsHolder, actual);
    }

    public void testGetLongHolder() {
        expect.oneCall(holderMap, longHolder, "getLongHolder", key);
        LongHolder actual = subject.getLongHolder(key);
        assertEquals(longHolder, actual);
    }

    public void testExists() {
        expect.oneCall(holderMap, boolValue, "exists", key);
        boolean actual = subject.exists(key);
        boolean expected = boolValue.booleanValue();
        assertEquals(expected, actual);
    }

    public void testPutString() {
        expect.oneCall(typedMap, VOID, "put", key, stringValue);
        subject.put(key, stringValue);
    }

    public void testPutInt() {
        expect.oneCall(typedMap, VOID, "put", key, intValue);
        subject.put(key, intValue);
    }

    public void testPutBoolean() {
        expect.oneCall(typedMap, VOID, "put", key, boolValue);
        subject.put(key, boolValue);
    }

    public void testPutBytes() {
        expect.oneCall(typedMap, VOID, "put", key, bytesValue);
        subject.put(key, bytesValue);
    }

    public void testPutInts() {
        expect.oneCall(typedMap, VOID, "put", key, intsValue);
        subject.put(key, intsValue);
    }

    public void testPutLong() {
        expect.oneCall(typedMap, VOID, "put", key, longValue);
        subject.put(key, longValue);
    }

    public void testPutIntHolder() {
        expect.oneCall(holderMap, VOID, "put", key, intHolder);
        subject.put(key, intHolder);
    }

    public void testPutStringHolder() {
        expect.oneCall(holderMap, VOID, "put", key, stringHolder);
        subject.put(key, stringHolder);
    }

    public void testPutBytesHolder() {
        expect.oneCall(holderMap, VOID, "put", key, bytesHolder);
        subject.put(key, bytesHolder);
    }

    public void testBooleanHolder() {
        expect.oneCall(holderMap, VOID, "put", key, booleanHolder);
        subject.put(key, booleanHolder);
    }

    public void testIntsHolder() {
        expect.oneCall(holderMap, VOID, "put", key, intsHolder);
        subject.put(key, intsHolder);
    }

    public void testLongHolder() {
        expect.oneCall(holderMap, VOID, "put", key, longHolder);
        subject.put(key, longHolder);
    }
}
