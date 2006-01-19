package au.net.netstorm.boost.util.io;

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
            throw new EdgeIoException(e);
        }
    }

    public void close() {
        // FIXME: SC050 Replace with NIE.
        throw new RuntimeException("NOT IMPLEMENTED YET");
    }
}