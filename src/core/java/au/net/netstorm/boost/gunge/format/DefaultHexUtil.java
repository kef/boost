package au.net.netstorm.boost.gunge.format;

public final class DefaultHexUtil implements HexUtil {
    public byte[] toBytes(String hex) {
        validate(hex);
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; ++i) {
            char first = hex.charAt(i * 2);
            char second = hex.charAt(i * 2 + 1);
            bytes[i] = (byte) (digit(first) << 4 | digit(second));
        }
        return bytes;
    }

    public String toString(byte[] bytes) {
        char[] chars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; ++i) {
            chars[i * 2] = Character.forDigit(bytes[i] >>> 4 & 0xf, 16);
            chars[i * 2 + 1] = Character.forDigit(bytes[i] & 0xf, 16);
        }
        return new String(chars);
    }

    private int digit(char hex) {
        return Character.digit(hex, 16);
    }

    private void validate(String hex) {
        if (!hex.matches("[0-9a-fA-F]+")) throw new IllegalArgumentException("Invalid hex string: " + hex);
    }
}

