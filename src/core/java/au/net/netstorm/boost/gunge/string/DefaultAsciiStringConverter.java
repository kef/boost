package au.net.netstorm.boost.gunge.string;

import au.net.netstorm.boost.gunge.type.AsciiBytes;
import au.net.netstorm.boost.gunge.type.DefaultAsciiBytes;

public final class DefaultAsciiStringConverter implements AsciiStringConverter {
    private static final String US_ASCII = "US-ASCII";
    StringConverter converter;

    public AsciiBytes convert(String string) {
        byte[] bytes = converter.convert(string, US_ASCII);
        return new DefaultAsciiBytes(bytes);
    }

    public String convert(AsciiBytes asciiBytes) {
        byte[] bytes = asciiBytes.getValue();
        return converter.convert(bytes, US_ASCII);
    }
}
