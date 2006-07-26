package au.net.netstorm.boost.edge.java.io;

import java.io.IOException;

import au.net.netstorm.boost.edge.EdgeException;

public final class EdgeIoException extends EdgeException {
    public EdgeIoException(IOException cause) {
        super(cause);
    }
}
