package au.net.netstorm.boost.gunge.io;

import au.net.netstorm.boost.sledge.java.io.EdgeInputStream;
import au.net.netstorm.boost.sledge.java.io.EdgeOutputStream;

public interface StreamConverter {
    void write(EdgeOutputStream destination, byte[] bytes);

    byte[] read(EdgeInputStream stream);
}
