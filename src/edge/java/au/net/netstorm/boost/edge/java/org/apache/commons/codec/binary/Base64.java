package au.net.netstorm.boost.edge.java.org.apache.commons.codec.binary;

public interface Base64 {
    byte[] decodeBase64(byte[] bytes);

    byte[] encodeBase64(byte[] bytes);

    byte[] encodeBase64(byte[] der, boolean inChunks);
}
