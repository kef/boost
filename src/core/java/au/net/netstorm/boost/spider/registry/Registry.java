package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Registry {
    // FIX ()   2237 Add specific host, name for all methods?
    <T, U extends T> void multiple(Class<T> iface, Class<U> impl);

    <T, U extends T> void single(Class<T> iface, Class<U> impl);

    <T, U extends T> void single(Class<?> host, Class<T> iface, Class<U> impl);

    <T, U extends T> void single(Class<?> host, Class<T> iface, String name, Class<U> impl);

    <T, U extends T> void instance(Class<T> iface, U ref);

    void incoming(Class iface, Class<? extends Layer>... layers);

    <T extends Factory> void factory(Class<T> cls);

    void factory(Factory factory);
}
