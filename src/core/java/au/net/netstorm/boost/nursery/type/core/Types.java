package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.util.type.Data;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public interface Types {
    <T extends Holder> T nu(Class<T> iface, Object value);

    <T extends Data> T nu(Class<T> iface, Object... values);
}
