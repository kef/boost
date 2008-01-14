package au.net.netstorm.boost.spider.registry;

public final class DefaultRegistryChainer implements RegistryChainer {
    public <T> void chain(Registry registry, Class<T> iface, Class<? extends T>... impl) {
        registry.single(iface, impl[0]);
        for (int i = 0; i < impl.length - 1; i++) {
            registry.single(impl[i], iface, impl[i + 1]);
        }
    }
}
