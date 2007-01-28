package au.net.netstorm.boost.edge.java.io;

import java.io.IOException;
import java.io.OutputStream;
import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeOutputStream implements EdgeOutputStream {
    private final OutputStream stream;

    public DefaultEdgeOutputStream(OutputStream stream) {
        this.stream = stream;
    }

    public void write(byte[] bytes) {
        try {
            stream.write(bytes);
        } catch (IOException e) {
            throw new EdgeException(e);
        }
    }

    public void flush() {
        try {
            stream.flush();
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
