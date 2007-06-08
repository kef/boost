package au.net.netstorm.boost.type.map.core;

import java.util.List;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.test.automock.UsesExpectations;

public final class DefaultTypedMapAtomicTest extends InteractionTestCase implements HasSubjects, UsesExpectations, UsesAutoMocks {
    TypedMapWrite typedMapWrite;
    TypedMapRead typedMapRead;
    Boolean illegalGetValue;
    String[] stringArray;
    Boolean booleanValue;
    String stringValue;
    Integer intValue;
    TypedMap subject;
    byte[] byteArray;
    int[] intArray;
    List arrayList;
    Long longValue;
    StringMap map;
    String key;

    public void setupSubjects() {
        subject = new DefaultTypedMap(typedMapRead, typedMapWrite);
    }

    public void testGetString() {
        expect.oneCall(typedMapRead, stringValue, "getString", key);
        String actual = subject.getString(key);
        assertEquals(stringValue, actual);
    }

    public void testGetInt() {
        int expected = intValue.intValue();
        expect.oneCall(typedMapRead, expected, "getInt", key);
        int actual = subject.getInt(key);
        assertEquals(expected, actual);
    }

    public void testGetLong() {
        long expected = longValue.longValue();
        expect.oneCall(typedMapRead, expected, "getLong", key);
        long actual = subject.getLong(key);
        assertEquals(expected, actual);
    }

    public void testGetBytes() {
        expect.oneCall(typedMapRead, byteArray, "getBytes", key);
        byte[] actual = subject.getBytes(key);
        assertEquals(byteArray, actual);
    }

    public void testGetBoolean() {
        expect.oneCall(typedMapRead, booleanValue, "getBoolean", key);
        boolean actual = subject.getBoolean(key);
        assertEquals(booleanValue, actual);
    }

    public void testExists() {
        boolean expected = booleanValue.booleanValue();
        expect.oneCall(typedMapRead, expected, "exists", key);
        boolean actual = subject.exists(key);
        assertEquals(expected, actual);
    }

    public void testGetInts() {
        expect.oneCall(typedMapRead, intArray, "getInts", key);
        int[] actual = subject.getInts(key);
        assertEquals(intArray, actual);
    }

    public void testPutString() {
        expect.oneCall(typedMapWrite, VOID, "put", key, stringValue);
        subject.put(key, stringValue);
    }

    public void testPutBoolean() {
        expect.oneCall(typedMapWrite, VOID, "put", key, booleanValue);
        subject.put(key, booleanValue);
    }

    public void testPutInt() {
        expect.oneCall(typedMapWrite, VOID, "put", key, intValue);
        subject.put(key, intValue);
    }

    public void testPutBytes() {
        expect.oneCall(typedMapWrite, VOID, "put", key, byteArray);
        subject.put(key, byteArray);
    }

    public void testPutLong() {
        expect.oneCall(typedMapWrite, VOID, "put", key, longValue);
        subject.put(key, longValue);
    }

    public void testPutInts() {
        expect.oneCall(typedMapWrite, VOID, "put", key, intArray);
        subject.put(key, intArray);
    }
}
