package au.net.netstorm.boost.pebble.core;

public interface PebbleProvider {
    Object provide(Class type, Object[] parameters);
}
