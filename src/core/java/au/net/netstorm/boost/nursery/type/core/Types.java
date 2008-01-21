package au.net.netstorm.boost.nursery.type.core;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public interface Types {
    <T> T nu(Class<T> iface, Object value);

    <T> T nu(Class<T> iface, Object... values);
}
