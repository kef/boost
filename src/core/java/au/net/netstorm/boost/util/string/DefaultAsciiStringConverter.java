package au.net.netstorm.boost.util.string;

import au.net.netstorm.boost.util.type.AsciiBytes;
import au.net.netstorm.boost.util.type.DefaultAsciiBytes;

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
