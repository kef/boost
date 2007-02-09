package au.net.netstorm.boost.pebble.type;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Interface;

public interface Implementation extends Data {
    Interface[] getTypes();

    Class getImpl();
}
