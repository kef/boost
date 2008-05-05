package au.net.netstorm.boost.nursery.gunge.format;

public interface HexUtil {
    byte[] toBytes(String hex);

    String toString(byte[] bytes);
}
