package au.net.netstorm.boost.edge.testfixtures;

import java.io.InputStream;
import java.lang.reflect.Method;

//FIX 2328 tidy up fixtures, particularly the names for the data pars
public interface EdgeStreamFixture {
    String method();

    Class<?>[] types();

    Method edge();

    Method real();

    byte[] data();

    // FIX 2328 Return Integer.  Primitive suck.
    // FIX 2328 This will get rid of warnings in DAEAT.

    int length();

    InputStream stream();
}
