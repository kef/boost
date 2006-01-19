package au.net.netstorm.boost.util.io;

import java.io.IOException;
import java.io.OutputStream;

// FIXME: SC050 EdgeStream as common interface for streams.
// FIXME: SC050 DEOS and DEIS can then share common code. 
public final class DefaultEdgeOutputStream implements EdgeOutputStream {
    private final OutputStream stream;

    public DefaultEdgeOutputStream(OutputStream stream) {
        this.stream = stream;
    }

    public void write(byte[] bytes) {
        try {
            stream.write(bytes);
        } catch (IOException e) {
            throw new EdgeIoException(e);
        }
    }

    public void flush() {
        try {
            stream.flush();
        } catch (IOException e) {
            throw new EdgeIoException(e);
        }
    }

    public void close() {
        try {
            stream.close();
        } catch (IOException e) {
            throw new EdgeIoException(e);
        }
    }
}
