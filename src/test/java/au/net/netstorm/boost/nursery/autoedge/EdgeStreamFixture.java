package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;

public interface EdgeStreamFixture {
    String method();
    Class<?>[] types();
    Method src();
    Method trg();

    byte[] data();
    int length();
    InputStream stream();
}
