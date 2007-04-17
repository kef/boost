package au.net.netstorm.boost.util.format;

public interface HexUtil {
    byte[] toBytes(String hex);

    String toString(byte[] bytes);
}
