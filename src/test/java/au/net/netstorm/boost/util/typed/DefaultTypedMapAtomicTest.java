package au.net.netstorm.boost.util.typed;

import java.util.List;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX BREADCRUMB 8888 Tidy
public final class DefaultTypedMapAtomicTest extends InteractionTestCase implements HasFixtures {
    TypedMapWrite typedMapWriteMock;
    TypedMapRead typedMapReadMock;
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
    String key;

    public void setUpFixtures() {
        subject = new DefaultTypedMap(typedMapReadMock, typedMapWriteMock);
    }

    public void testGetString() {
        expect.oneCall(typedMapReadMock, stringValue, "getString", key);
        String actual = subject.getString(key);
        assertEquals(stringValue, actual);
    }

    public void testGetInt() {
        int expected = intValue.intValue();
        expect.oneCall(typedMapReadMock, expected, "getInt", key);
        int actual = subject.getInt(key);
        assertEquals(expected, actual);
    }

    public void testGetLong() {
        long expected = longValue.longValue();
        expect.oneCall(typedMapReadMock, expected, "getLong", key);
        long actual = subject.getLong(key);
        assertEquals(expected, actual);
    }

    public void testGetBytes() {
        expect.oneCall(typedMapReadMock, byteArray, "getBytes", key);
        byte[] actual = subject.getBytes(key);
        assertEquals(byteArray, actual);
    }

    public void testGetBoolean() {
        expect.oneCall(typedMapReadMock, booleanValue, "getBoolean", key);
        boolean actual = subject.getBoolean(key);
        assertEquals(booleanValue, actual);
    }

    public void testExists() {
        boolean expected = booleanValue.booleanValue();
        expect.oneCall(typedMapReadMock, expected, "exists", key);
        boolean actual = subject.exists(key);
        assertEquals(expected, actual);
    }

    public void testGetInts() {
        expect.oneCall(typedMapReadMock, intArray, "getInts", key);
        int[] actual = subject.getInts(key);
        assertEquals(intArray, actual);
    }

    public void testGetStrings() {
        expect.oneCall(typedMapReadMock, stringArray, "getStrings", key);
        String[] actual = subject.getStrings(key);
        assertEquals(stringArray, actual);
    }

    public void testPutString() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, stringValue);
        subject.put(key, stringValue);
    }

    public void testPutBoolean() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, booleanValue);
        subject.put(key, booleanValue);
    }

    public void testPutInt() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, intValue);
        subject.put(key, intValue);
    }

    public void testPutBytes() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, byteArray);
        subject.put(key, byteArray);
    }

    public void testPutLong() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, longValue);
        subject.put(key, longValue);
    }

    public void testPutInts() {
        expect.oneCall(typedMapWriteMock, VOID, "put", key, intArray);
        subject.put(key, intArray);
    }
}