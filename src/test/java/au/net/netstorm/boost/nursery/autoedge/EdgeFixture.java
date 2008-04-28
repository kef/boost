package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;

public interface EdgeFixture {
    byte[] data();
    int length();
    InputStream stream();
    Method read();
}
