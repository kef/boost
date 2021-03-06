package au.net.netstorm.boost.gunge.io;

import au.net.netstorm.boost.sniper.core.BoooostCase;

public final class DefaultStreamConverterAtomicTest extends BoooostCase {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final byte[] BYTE_ARRAY_1 = bytes("The bravery of being out of range.");
    private static final byte[] BYTE_ARRAY_2 = bytes("You deafen the canyon.");
    private final StreamConverter converter = new DefaultStreamConverter();

    public void testWrites() {
        checkToStream(EMPTY_BYTE_ARRAY);
        checkToStream(BYTE_ARRAY_1);
        checkToStream(BYTE_ARRAY_2);
    }

    public void testReads() {
        checkReads(EMPTY_BYTE_ARRAY);
        checkReads(BYTE_ARRAY_1);
        checkReads(BYTE_ARRAY_2);
    }

    private void checkReads(byte[] bytes) {
        MockEdgeInputStream stream = new MockEdgeInputStream();
        stream.init(bytes);
        byte[] result = converter.read(stream);
        assertEquals(bytes, result);
    }

    private void checkToStream(byte[] bytes) {
        MockEdgeOutputStream mockStream = new MockEdgeOutputStream();
        converter.write(mockStream, bytes);
        mockStream.verify(bytes);
    }

    private static byte[] bytes(String s) {
        return s.getBytes();
    }
}