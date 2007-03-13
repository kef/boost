package au.net.netstorm.boost.pebble.inject.newer.core;

public interface ObjectProvider {
    Object provide(Class type, Object[] parameters);
}
