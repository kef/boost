package au.net.netstorm.boost.nursery.autoedge.testfixtures;

import java.lang.reflect.Constructor;
import java.net.URL;

//FIX 2328 tidy up fixtures, particularly the names for the data pars
public interface EdgeURLFixture {
    Constructor<?> constructor();

    String value();

    URL url();
}
