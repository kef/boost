package au.net.netstorm.boost.type.util.string;

import java.io.UnsupportedEncodingException;
import au.net.netstorm.boost.edge.java.io.EdgeUnsupportedEncodingException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultStringConverterAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    private static final String CHARSET_GOOD = "UTF-8";
    private static final String CHARSET_BAD = "BAD-8";
    StringConverter subject;
    String someString;
    byte[] someBytes;

    public void setupSubjects() {
        subject = new DefaultStringConverter();
    }

    public void testConvertToBytes() throws UnsupportedEncodingException {
        byte[] actual = subject.convert(someString, CHARSET_GOOD);
        byte[] bytes = someString.getBytes(CHARSET_GOOD);
        assertEquals(bytes, actual);
    }

    public void testConvertToString() throws UnsupportedEncodingException {
        byte[] bytes = someString.getBytes(CHARSET_GOOD);
        String actual = subject.convert(bytes, CHARSET_GOOD);
        assertEquals(someString, actual);
    }

    public void testConvertToBytesFails() {
        try {
            subject.convert(someBytes, CHARSET_BAD);
            fail();
        } catch (EdgeUnsupportedEncodingException expected) { }
    }

    public void testConvertToStringFails() {
        try {
            subject.convert(someString, CHARSET_BAD);
            fail();
        } catch (EdgeUnsupportedEncodingException expected) { }
    }
}
