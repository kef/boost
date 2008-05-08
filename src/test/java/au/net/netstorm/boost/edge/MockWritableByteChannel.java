package au.net.netstorm.boost.edge;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

final class MockWritableByteChannel extends Assert implements WritableByteChannel {
    private boolean open = true;
    private boolean called = false;
    private ByteBuffer expected;
    private int length;

    public MockWritableByteChannel(ByteBuffer expected, int length) {
        this.expected = expected;
        this.length = length;
    }

    public int write(ByteBuffer src) throws IOException {
        if (!open) throw new IOException();
        if (called) throw new AssertionFailedError("Can only be called once");
        called = true;
        assertEquals(expected, src);
        return length;
    }

    public void close() throws IOException {
        if (!open) throw new IOException();
        if (!called) throw new AssertionFailedError("Must be called once");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
