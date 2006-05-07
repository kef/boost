package au.net.netstorm.boost.java.io;

import java.io.IOException;

import au.net.netstorm.boost.misc.EdgeException;

public final class EdgeIoException extends EdgeException {
    public EdgeIoException(IOException cause) {
        super(cause);
    }
}
