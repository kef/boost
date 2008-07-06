package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2394 Genericise the Target so we get strong typing across into the resolution (target methods)?
public interface Binder {
    Target bind(Class<?> iface, Class<?> host, String name);
    Target bind(Class<?> iface, Class<?> host);
    Target bind(Class<?> iface, String name);
    Target bind(Class<?> iface);
    Target bind(InjectionType type, Class<?> host, String name);
    Target bind(InjectionType type, Class<?> host);
    Target bind(InjectionType type, String name);
    Target bind(InjectionType type);
}
