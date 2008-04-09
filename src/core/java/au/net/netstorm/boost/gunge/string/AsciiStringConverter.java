package au.net.netstorm.boost.gunge.string;

import au.net.netstorm.boost.gunge.type.AsciiBytes;

public interface AsciiStringConverter {
    AsciiBytes convert(String string);

    String convert(AsciiBytes asciiBytes);
}
