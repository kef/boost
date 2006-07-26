package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.edge.java.io.EdgeOutputStream;
import au.net.netstorm.boost.util.exception.NotImplementedException;

public final class MockEdgeOutputStream implements EdgeOutputStream {
    public void write(byte[] bytes) {
        throw new NotImplementedException();
    }

    public void flush() {
        throw new NotImplementedException();
    }

    public void close() {
        throw new NotImplementedException();
    }
}
