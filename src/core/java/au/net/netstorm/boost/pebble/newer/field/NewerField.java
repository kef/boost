package au.net.netstorm.boost.pebble.newer.field;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Interface;

public interface NewerField extends Data {
    Interface getNewerInterface();

    Class getInstanceImplementation();

    String getFieldName();
}
