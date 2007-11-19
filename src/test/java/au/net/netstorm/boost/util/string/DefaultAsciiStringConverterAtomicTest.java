package au.net.netstorm.boost.util.string;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InjectableSubject;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.AsciiBytes;

public final class DefaultAsciiStringConverterAtomicTest extends InteractionTestCase implements HasFixtures, InjectableSubject {
    private static final String ASCII_ENCODING = "US-ASCII";
    private byte[] bytes;
    AsciiStringConverter subject;
    StringConverter converterMock;
    AsciiBytes asciiBytes;
    String str;

    public void setUpFixtures() {
        subject = new DefaultAsciiStringConverter();
        bytes = asciiBytes.getValue();
    }

    public void testToAscii() {
        expect.oneCall(converterMock, bytes, "convert", str, ASCII_ENCODING);
        AsciiBytes actual = subject.convert(str);
        assertEquals(asciiBytes, actual);
    }

    public void testToBytes() {
        expect.oneCall(converterMock, str, "convert", bytes, ASCII_ENCODING);
        String actual = subject.convert(asciiBytes);
        assertEquals(str, actual);
    }
}