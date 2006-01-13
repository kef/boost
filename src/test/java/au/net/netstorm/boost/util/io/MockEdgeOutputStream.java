package au.net.netstorm.boost.util.io;

import junit.framework.Assert;

final class MockEdgeOutputStream extends Assert implements EdgeOutputStream {
    private final TestAsserter asserter = new TestAsserter();
    private byte[] actual;
    private boolean flushed = false;
    private boolean writeCalled = false;

    public void flush() {
        if (!writeCalled) fail("write(...) must be called prior to flush().");
        flushed = true;
    }

    public void write(byte[] bytes) {
        if (writeCalled) fail("Expecting a single call only to write.");
        writeCalled = true;
        actual = bytes;
    }

    public void verify(byte[] expected) {
        asserter.assertEquals(expected, actual);
        assertTrue(flushed);
    }
}
