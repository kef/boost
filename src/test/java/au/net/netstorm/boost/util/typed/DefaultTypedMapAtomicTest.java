package au.net.netstorm.boost.util.typed;

import java.util.List;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

// FIX BREADCRUMB 8888 Tidy
public final class DefaultTypedMapAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    TypedMapWrite typedMapWriteMock;
    TypedMapRead typedMapReadMock;
    Boolean illegalGetValue;
    String[] stringArray;
    Boolean booleanValue;
    String stringValue;
    Integer intValue;
    TypedMap subject;
    byte[] byteArray;
    Integer[] intArray;
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
        expect.oneCall(typedMapReadMock, intValue, "getInt", key);
        Integer actual = subject.getInt(key);
        assertEquals(intValue, actual);
    }

    public void testGetLong() {
        expect.oneCall(typedMapReadMock, longValue, "getLong", key);
        Long actual = subject.getLong(key);
        assertEquals(longValue, actual);
    }

    public void testGetBytes() {
        expect.oneCall(typedMapReadMock, byteArray, "getBytes", key);
        byte[] actual = subject.getBytes(key);
        assertEquals(byteArray, actual);
    }

    public void testGetBoolean() {
        expect.oneCall(typedMapReadMock, booleanValue, "getBoolean", key);
        Boolean actual = subject.getBoolean(key);
        assertEquals(booleanValue, actual);
    }

    public void testExists() {
        expect.oneCall(typedMapReadMock, booleanValue, "exists", key);
        Boolean actual = subject.exists(key);
        assertEquals(booleanValue, actual);
    }

    public void testGetInts() {
        expect.oneCall(typedMapReadMock, intArray, "getInts", key);
        Integer[] actual = subject.getInts(key);
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
