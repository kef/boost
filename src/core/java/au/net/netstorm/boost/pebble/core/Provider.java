package au.net.netstorm.boost.pebble.core;

public interface Provider {
    Object provide(Class type, Object[] parameters);
}
