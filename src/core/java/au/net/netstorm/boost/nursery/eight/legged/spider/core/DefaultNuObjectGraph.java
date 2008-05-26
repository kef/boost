package au.net.netstorm.boost.nursery.eight.legged.spider.core;

public final class DefaultNuObjectGraph implements NuObjectGraph {
    private final NuInjectionGraph injections;

    public DefaultNuObjectGraph(NuInjectionGraph injections) {
        this.injections = injections;
    }

    public <T> T nu(Class<T> root, Object... args) {
        InjectionGraph<T> graph = injections.nu(root);
        return graph.apply(args);
    }
}
