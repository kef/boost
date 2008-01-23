package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Registry {
    // FIX ()   2237 Add specific host, name for all methods?
    <T> void multiple(Class<T> iface, Class<? extends T> impl);

    <T> void single(Class<T> iface, Class<? extends T> impl);

    <T> void single(Class host, Class<T> iface, Class<? extends T> impl);

    <T> void single(Class host, Class<T> iface, String name, Class<? extends T> impl);

    void layer(Class impl, Class<? extends Layer>... layers);

    <T, U extends T> void instance(Class<T> iface, U ref);

    <T extends Factory> void factory(Class<T> cls);

    void factory(Factory factory);
}
