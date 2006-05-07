package au.net.netstorm.boost.java.io;

import java.io.Serializable;

import au.net.netstorm.boost.test.checker.AssertTestChecker;
import au.net.netstorm.boost.test.checker.DefaultAssertTestChecker;
import junit.framework.Assert;

public final class MockEdgeOutputStream extends Assert implements EdgeOutputStream, Serializable {
    private final transient AssertTestChecker asserter = new DefaultAssertTestChecker();
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
        asserter.checkEquals(expected, actual);
        assertTrue(flushed);
    }
}