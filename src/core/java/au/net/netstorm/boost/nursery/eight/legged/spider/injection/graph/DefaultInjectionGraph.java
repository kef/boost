package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

public final class DefaultInjectionGraph<T> implements InjectionGraph<T> {
    private final Class<T> type;
    private final Injection root;

    public DefaultInjectionGraph(Class<T> type, Injection root) {
        this.type = type;
        this.root = root;
    }

    public T apply() {
        Object o = root.apply();
        return type.cast(o);
    }
}