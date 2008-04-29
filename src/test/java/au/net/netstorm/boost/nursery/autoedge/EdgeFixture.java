package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

// TODO-MH should be split out into a URLEdgeFixture and a InputStreamEdgeFixture
public interface EdgeFixture {
    String value();
    URL url();
    byte[] data();
    int length();
    InputStream stream();
    Method read();
}
