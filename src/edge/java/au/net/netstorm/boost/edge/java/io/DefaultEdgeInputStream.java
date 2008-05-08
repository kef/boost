package au.net.netstorm.boost.edge.java.io;

import au.net.netstorm.boost.edge.guts.EdgeException;

import java.io.IOException;
import java.io.InputStream;

public final class DefaultEdgeInputStream implements EdgeInputStream {
    private final InputStream stream;

    public DefaultEdgeInputStream(InputStream stream) {
        this.stream = stream;
    }

    public int read(byte[] buf) {
        try {
            return stream.read(buf);
        } catch (IOException e) {
            throw new EdgeException(e);
        }
    }

    public void close() {
        try {
            stream.close();
        } catch (IOException e) {
            throw new EdgeException(e);
        }
    }
}
