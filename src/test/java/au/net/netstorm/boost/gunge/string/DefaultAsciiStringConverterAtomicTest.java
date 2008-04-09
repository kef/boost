package au.net.netstorm.boost.gunge.string;

import au.net.netstorm.boost.gunge.type.AsciiBytes;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultAsciiStringConverterAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, LazyFields {
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