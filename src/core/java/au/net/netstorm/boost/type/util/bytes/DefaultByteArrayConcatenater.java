package au.net.netstorm.boost.type.util.bytes;

public final class DefaultByteArrayConcatenater implements ByteArrayConcatenater {
    public byte[] concatenate(byte[] array1, byte[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        byte[] concatenation = new byte[length1 + length2];
        System.arraycopy(array1, 0, concatenation, 0, length1);
        System.arraycopy(array2, 0, concatenation, length1, length2);
        return concatenation;
    }
}
