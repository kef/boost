package au.net.netstorm.boost.type.util.string;

import au.net.netstorm.boost.edge.java.io.EdgeUnsupportedEncodingException;

public final class DefaultStringConverter implements StringConverter {
    public String convert(byte[] bytes, String charSet) {
        try {
            return new String(bytes, charSet);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new EdgeUnsupportedEncodingException(e);
        }
    }

    public byte[] convert(String str, String charSet) {
        try {
            return str.getBytes(charSet);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new EdgeUnsupportedEncodingException(e);
        }
    }
}
