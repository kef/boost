package au.net.netstorm.boost.pebble.create;

public interface Creator {
    Object create(Class type, Object[] parameters);
}
