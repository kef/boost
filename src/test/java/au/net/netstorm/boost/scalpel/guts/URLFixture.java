package au.net.netstorm.boost.scalpel.guts;

import java.lang.reflect.Constructor;
import java.net.URL;

public interface URLFixture {
    Constructor<?> constructor();

    URL real();

    String arg();
}
