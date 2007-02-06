package au.net.netstorm.boost.nursery.pebble.create;

// FIX 1665 Is this the Engine pattern at work?
public interface GenericCreator {
    Object create(Class type, Object[] parameters);
}
