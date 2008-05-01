package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Constructor;
import java.net.URL;

public interface EdgeURLFixture {
    Constructor<?> constructor();
    String value();
    URL url();
}
