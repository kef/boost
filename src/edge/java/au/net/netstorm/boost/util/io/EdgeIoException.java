package au.net.netstorm.boost.util.io;

import java.io.IOException;

public final class EdgeIoException extends RuntimeException {
    public EdgeIoException(IOException cause) {
        super(cause);
    }
}
