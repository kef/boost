package au.net.netstorm.boost.type.strong;

import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultAsciiMapAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    AsciiMap subject;
    String key;
    AsciiBytes asciiBytes;
    String otherKey;
    AsciiBytes otherAsciiBytes;

    public void setupSubjects() {
        subject = new DefaultAsciiMap();
    }

    public void testPutSuccess() {
        checkPut(key, asciiBytes);
        checkPut(otherKey, otherAsciiBytes);
    }

    public void testGetFail() {
        try {
            subject.get(key);
            fail();
        } catch (IllegalArgumentException expected) {
            String message = expected.getMessage();
            assertEquals(true, message.equals(key + " does not exist."));
        }
    }

    public void testExists() {
        subject.put(key, asciiBytes);
        checkExists(key, true);
        checkExists(otherKey, false);
    }

    public void testEntrySet() {
        subject.put(key, asciiBytes);
        subject.put(otherKey, otherAsciiBytes);
        Set actual = subject.entrySet();
        Map.Entry[] entries = (Map.Entry[]) actual.toArray(new Map.Entry[]{});
        assertEquals(2, entries.length);
        checkEntry(entries, key, asciiBytes);
        checkEntry(entries, otherKey, otherAsciiBytes);
    }

    private void checkEntry(Map.Entry[] entries, String expectedKey, AsciiBytes expectedValue) {
        for (int i = 0; i < entries.length; i++) {
            Map.Entry entry = entries[i];
            if (expectedKey == entry.getKey()) {
                Object actualValue = entries[i].getValue();
                assertEquals(expectedValue, actualValue);
            }
        }
    }

    private void checkExists(String key, boolean expected) {
        boolean actual = subject.exists(key);
        assertEquals(expected, actual);
    }

    private void checkPut(String key1, AsciiBytes value) {
        subject.put(key1, value);
        AsciiBytes actual = subject.get(key);
        assertEquals(asciiBytes, actual);
    }
}

