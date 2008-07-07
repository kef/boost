package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2394 Genericise the Target so we get strong typing across into the resolution (target methods)?
public interface Binder {
    <T> Target<T> bind(Class<T> iface, Class<?> host, String name);

    <T> Target<T> bind(Class<T> iface, Class<?> host);

    // FIX 2394 MAG Remove these dang line feeds.
    <T> Target<T> bind(Class<T> iface, String name);

    <T> Target<T> bind(Class<T> iface);

    <T> Target<T> bind(InjectionType<T> type, Class<?> host, String name);

    <T> Target<T> bind(InjectionType<T> type, Class<?> host);

    <T> Target<T> bind(InjectionType<T> type, String name);

    <T> Target<T> bind(InjectionType<T> type);
}
