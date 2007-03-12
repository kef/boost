package au.net.netstorm.boost.pebble.create;

public interface ObjectProvider {
    Object create(Class type, Object[] parameters);
}
