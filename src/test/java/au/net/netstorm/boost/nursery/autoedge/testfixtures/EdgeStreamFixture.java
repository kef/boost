package au.net.netstorm.boost.nursery.autoedge.testfixtures;

import java.io.InputStream;
import java.lang.reflect.Method;

//FIX 2328 tidy up fixtures, particularly the names for the data pars
public interface EdgeStreamFixture {
    String method();

    Class<?>[] types();

    Method edge();

    Method real();

    byte[] data();

    int length();

    InputStream stream();
}
