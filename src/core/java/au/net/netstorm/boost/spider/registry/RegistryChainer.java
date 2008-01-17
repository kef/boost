package au.net.netstorm.boost.spider.registry;

public interface RegistryChainer {
    <T> void chain(Registry registry, Class<T> iface, Class<? extends T>... impls);
}
