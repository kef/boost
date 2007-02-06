package au.net.netstorm.boost.nursery.pebble.instantiate;

// FIX 1665 Merge with GenericCreator.
public interface Instantiator {
    Object instantiate(Class type, Object[] parameters);
}
