package au.net.netstorm.boost.pebble.instantiate;

public interface Instantiator {
    Object instantiate(Class type, Object[] parameters);
}
