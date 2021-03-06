package au.net.netstorm.boost.gunge.string;

import java.io.UnsupportedEncodingException;
import au.net.netstorm.boost.sledge.java.io.EdgeUnsupportedEncodingException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultStringConverterAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final String ENCODING = "UTF-8";
    private byte[] bytes;
    StringConverter subject;
    String str;
    String badEncoding;

    public void setUpFixtures() {
        subject = new DefaultStringConverter();
        bytes = convertToBytes(str);
    }

    public void testToBytes() {
        byte[] actual = subject.convert(str, ENCODING);
        assertEquals(bytes, actual);
    }

    public void testToBytesFailes() {
        try {
            subject.convert(str, badEncoding);
            fail();
        } catch (EdgeUnsupportedEncodingException e) {
        }
    }

    public void testToString() {
        String actual = subject.convert(bytes, ENCODING);
        assertEquals(str, actual);
    }

    public void testToStringFails() {
        try {
            subject.convert(bytes, badEncoding);
            fail();
        } catch (EdgeUnsupportedEncodingException e) {
        }
    }

    private byte[] convertToBytes(String str) {
        try {
            return str.getBytes(ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}