package au.net.netstorm.boost.util.string;

import au.net.netstorm.boost.util.type.AsciiBytes;

public interface AsciiStringConverter {
    AsciiBytes convert(String string);

    String convert(AsciiBytes asciiBytes);
}
