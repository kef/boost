package au.net.netstorm.boost.type.util.bytes;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultBytesSplitterAtomicTest extends InteractionTestCase implements HasSubjects {
    BytesSplitter subject;
    String simple = "brisbane=";
    String lessSimple = "brisbane=broncos\n";
    String valueWithNoDelimiter = "melbourne=storm";
    String complexNameValue = "sunnygoldcoast%titans#willwin";

    public void setupSubjects() {
        subject = new DefaultBytesSplitter();
    }

    public void testSplit() {
        checkSplit(simple, 0, "=", "brisbane");
        checkSplit(lessSimple, 9, "\n", "broncos");
        checkSplit(valueWithNoDelimiter, 10, "\n", "storm");
    }

    public void testNameValueSplit() {
        checkSplit(complexNameValue, 5, "%", "goldcoast");
        checkSplit(complexNameValue, 15, "#", "titans");
    }

    private void checkSplit(String input, int startIndex, String delimiter, String output) {
        byte delimiterByte = getBytes(delimiter)[0];
        byte[] inputBytes = getBytes(input);
        byte[] actual = subject.split(inputBytes, startIndex, delimiterByte);
        byte[] expected = getBytes(output);
        assertEquals(expected, actual);
    }

    private byte[] getBytes(String str) {
        try {
            return str.getBytes("US-ASCII");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("Could not get bytes of the string " + str);
        }
    }
}
