package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2394 split into engine(InjectionType), raw(Class<T>) and generecized(nice wrapper to be implemented)
// FIX 2394 wrap in a Registry compatibality layer for migration
public interface Binder {
    <T> Target<T> bind(Class<T> iface, Class<?> host, String name);

    <T> Target<T> bind(Class<T> iface, Class<?> host);

    // FIX 2395 MAG Remove these dang line feeds.
    <T> Target<T> bind(Class<T> iface, String name);

    <T> Target<T> bind(Class<T> iface);

    // FIX 2395 make a nice way to call this from the outside.
    <T> Target<T> bind(InjectionType<T> type, Class<?> host, String name);

    <T> Target<T> bind(InjectionType<T> type, Class<?> host);

    <T> Target<T> bind(InjectionType<T> type, String name);

    <T> Target<T> bind(InjectionType<T> type);
}
