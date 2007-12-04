package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.util.type.Data;

public interface Types {
    <T extends Holder> T nu(Class<T> iface, Object value);

    <T extends Data> T nu(Class<T> iface, Object... values);
}
