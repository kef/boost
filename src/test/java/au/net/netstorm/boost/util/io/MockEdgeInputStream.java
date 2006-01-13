package au.net.netstorm.boost.util.io;

import junit.framework.Assert;

final class MockEdgeInputStream extends Assert implements EdgeInputStream {
    private static final int EOF = -1;
    private byte[] result;
    private int pos = 0;

    public int read(byte[] buf) {
        int remaining = result.length - pos;
        assertTrue(buf.length > remaining);
        if (remaining == 0) return EOF;
        int length = split(remaining);
        System.arraycopy(result, pos, buf, 0, length);
        advance(length);
        return length;
    }

    private void advance(int length) {
        pos += length;
    }

    void init(byte[] result) {
        this.result = result;
    }

    private int split(int remaining) {
        return (remaining == 1) ? 1 : remaining / 2;
    }
}
