package au.net.netstorm.boost.nursery.temp;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Interface;

public interface Implementation extends Data {
    Interface getType();

    Class getImpl();
}
