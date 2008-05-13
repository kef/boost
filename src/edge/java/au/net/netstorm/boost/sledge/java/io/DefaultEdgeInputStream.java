package au.net.netstorm.boost.sledge.java.io;

import java.io.IOException;
import java.io.InputStream;
import au.net.netstorm.boost.sledge.support.EdgeException;

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
