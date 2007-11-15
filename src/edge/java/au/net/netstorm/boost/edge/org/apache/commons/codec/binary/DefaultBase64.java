package au.net.netstorm.boost.edge.org.apache.commons.codec.binary;

public final class DefaultBase64 implements Base64 {
    public byte[] encodeBase64(byte[] bytes) {
        return org.apache.commons.codec.binary.Base64.encodeBase64(bytes);
    }

    public byte[] encodeBase64(byte[] bytes, boolean isChunked) {
        return org.apache.commons.codec.binary.Base64.encodeBase64(bytes, isChunked);
    }

    public byte[] decodeBase64(byte[] bytes) {
        return org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
    }
}
