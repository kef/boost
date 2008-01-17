package au.net.netstorm.boost.spider.registry;

public final class DefaultRegistryChainer implements RegistryChainer {
    public <T> void chain(Registry registry, Class<T> iface, Class<? extends T>... impls) {
        registry.single(iface, impls[0]);
        for (int i = 0; i < impls.length - 1; i++) {
            registry.single(impls[i], iface, impls[i + 1]);
        }
    }
}
