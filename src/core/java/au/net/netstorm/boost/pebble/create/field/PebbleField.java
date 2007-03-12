package au.net.netstorm.boost.pebble.create.field;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Interface;

public interface PebbleField extends Data {
    Interface getCreatorInterface();

    Class getInstanceImplementation();

    String getFieldName();
}
