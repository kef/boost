package au.net.netstorm.boost.util.io;

import au.net.netstorm.boost.java.io.EdgeInputStream;
import au.net.netstorm.boost.java.io.EdgeOutputStream;

public interface StreamConverter {
    void write(EdgeOutputStream destination, byte[] bytes);

    byte[] read(EdgeInputStream stream);
}
