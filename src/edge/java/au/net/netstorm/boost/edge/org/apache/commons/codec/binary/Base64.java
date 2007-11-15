package au.net.netstorm.boost.edge.org.apache.commons.codec.binary;

public interface Base64 {
    byte[] encodeBase64(byte[] bytes);

    byte[] decodeBase64(byte[] bytes);

    byte[] encodeBase64(byte[] bytes, boolean isChunked);
}
