package au.net.netstorm.boost.util.io;

import junit.framework.Assert;

import java.io.Serializable;

public final class MockEdgeOutputStream extends Assert implements EdgeOutputStream, Serializable {
    private final transient TestAsserter asserter = new TestAsserter();
    private byte[] actual;
    private boolean flushed = false;
    private boolean writeCalled = false;

    public void write(byte[] bytes) {
        if (writeCalled) fail("Expecting a single call only to write.");
        writeCalled = true;
        actual = bytes;
    }

    public void flush() {
        if (!writeCalled) fail("write(...) must be called prior to flush().");
        flushed = true;
    }

    public void close() {
        throw new RuntimeException("NOT IMPLEMENTED YET");
    }

    public void verify(byte[] expected) {
        asserter.assertEquals(expected, actual);
        assertTrue(flushed);
    }
}