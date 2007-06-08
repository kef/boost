package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.test.automock.UsesExpectations;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.DefaultBooleanHolder;
import au.net.netstorm.boost.type.strong.DefaultBytesHolder;
import au.net.netstorm.boost.type.strong.DefaultIntegerHolder;
import au.net.netstorm.boost.type.strong.DefaultLongHolder;
import au.net.netstorm.boost.type.strong.DefaultStringHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;
import au.net.netstorm.boost.type.util.core.TypeUtility;

public final class DefaultHolderMapAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks, UsesExpectations, InjectableSubject {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    HolderMap subject;
    TypeUtility typeUtility;
    Integer negativeInt = -10;
    Integer positiveInt = 987;
    Integer zeroInt = 0;
    TypedMap typedMap;
    String key;
    String randomString;
    Integer someInteger;
    BytesHolder baseBytesHolder;
    IntegerHolder intHolder1;
    IntegerHolder[] intHolders = {intHolder1};
    IntegerHolder integerHolder1 = new DefaultIntegerHolder(1);
    IntegerHolder integerHolder2 = new DefaultIntegerHolder(2);
    IntegerHolder integerHolder3 = new DefaultIntegerHolder(3);
    IntegerHolder[] intHolders3 = {integerHolder1, integerHolder2, integerHolder3};
    byte[] bytes0 = {};
    byte[] bytes1 = {1};
    byte[] bytes2 = {1, 2};
    int[] ints = {1};
    Boolean expectedExists;
    IntegerHolder integerHolder;
    StringHolder stringHolder;
    String someString;
    BooleanHolder booleanHolder;
    LongHolder longHolder;
    Boolean someBoolean;
    BytesHolder bytesHolder;
    Long longValue;
    Long someLong;

    public void setupSubjects() {
        subject = new DefaultHolderMap(typedMap);
    }

    public void testGetIntHolder() {
        checkGetIntHolder(negativeInt);
        checkGetIntHolder(positiveInt);
        checkGetIntHolder(zeroInt);
    }

    public void testGetStringHolder() {
        checkGetStringHolder(randomString);
    }

    public void testGetBytesHolder() {
        checkGetBytesHolder(bytes0);
        checkGetBytesHolder(bytes1);
        checkGetBytesHolder(bytes2);
    }

    public void testGetIntHolders() {
        checkGetIntHolders(ints, intHolders);
    }

    public void testGetLongHolder() {
        checkGetLongHolders(longValue);
    }

    public void testGetBooleanHolder() {
        checkGetBooleanHolder(someBoolean);
    }

    public void testExists() {
        checkExists();
    }

    public void testPutIntegerHolder() {
        expect.oneCall(integerHolder, someInteger, "getValue");
        expect.oneCall(typedMap, VOID, "put", key, someInteger);
        subject.put(key, integerHolder);
    }

    public void testPutStringHolder() {
        expect.oneCall(stringHolder, someString, "getValue");
        expect.oneCall(typedMap, VOID, "put", key, someString);
        subject.put(key, stringHolder);
    }

    public void testPutBooleanHolder() {
        expect.oneCall(booleanHolder, someBoolean, "isTroo");
        expect.oneCall(typedMap, VOID, "put", key, someBoolean);
        subject.put(key, booleanHolder);
    }

    public void testPutLongHolder() {
        expect.oneCall(longHolder, someLong, "getValue");
        expect.oneCall(typedMap, VOID, "put", key, someLong);
        subject.put(key, longHolder);
    }

    public void testPutBytesHolder() {
        expect.oneCall(bytesHolder, bytes2, "getValue");
        expect.oneCall(typedMap, VOID, "put", key, bytes2);
        subject.put(key, bytesHolder);
    }

    public void testPutIntegerHolders() {
        int[] ints3 = getExpectedIntArray();
        expect.oneCall(typedMap, VOID, "put", key, ints3);
        subject.put(key, intHolders3);
    }

    private int[] getExpectedIntArray() {
        int length = intHolders3.length;
        int[] ints3 = new int[length];
        for (int i = 0; i < length; i++) {
            ints3[i] = intHolders3[i].getValue();
        }
        return ints3;
    }

    private void checkExists() {
        expect.oneCall(typedMap, expectedExists, "exists", key);
        Boolean result = subject.exists(key);
        assertEquals(expectedExists, result);
    }

    private void checkGetIntHolders(int[] intArray, IntegerHolder[] expected) {
        expect.oneCall(typedMap, intArray, "getInts", key);
        expect.oneCall(typeUtility, expected, "toIntHolderArray", intArray);
        IntegerHolder[] result = subject.getIntsHolder(key);
        assertEquals(expected, result);
    }

    private void checkGetLongHolders(Long longValue) {
        expect.oneCall(typedMap, longValue, "getLong", key);
        LongHolder actual = subject.getLongHolder(key);
        LongHolder expected = new DefaultLongHolder(longValue);
        assertEquals(expected, actual);
    }

    private void checkGetBooleanHolder(Boolean value) {
        expect.oneCall(typedMap, value, "getBoolean", key);
        BooleanHolder actual = subject.getBooleanHolder(key);
        BooleanHolder expected = new DefaultBooleanHolder(someBoolean);
        assertEquals(expected, actual);
    }

    private void checkGetBytesHolder(byte[] someBytes) {
        BytesHolder expected = new DefaultBytesHolder(someBytes);
        expect.oneCall(typedMap, someBytes, "getBytes", key);
        BytesHolder result = subject.getBytesHolder(key);
        assertEquals(expected, result);
    }

    private void checkGetStringHolder(String randomString) {
        StringHolder expected = new DefaultStringHolder(randomString);
        expect.oneCall(typedMap, randomString, "getString", key);
        StringHolder result = subject.getStringHolder(key);
        assertEquals(expected, result);
    }

    private void checkGetIntHolder(int someInt) {
        IntegerHolder expected = new DefaultIntegerHolder(someInt);
        expect.oneCall(typedMap, someInt, "getInt", key);
        IntegerHolder result = subject.getIntHolder(key);
        assertEquals(expected, result);
    }
}
