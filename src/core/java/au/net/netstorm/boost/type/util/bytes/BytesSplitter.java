package au.net.netstorm.boost.type.util.bytes;

public interface BytesSplitter {
    byte[] split(byte[] input, int offset, byte delimiter);
}
