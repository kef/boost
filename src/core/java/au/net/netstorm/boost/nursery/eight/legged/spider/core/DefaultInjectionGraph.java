package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.RootInjection;

public final class DefaultInjectionGraph<T> implements InjectionGraph<T> {
    private final Class<T> type;
    private final RootInjection root;

    public DefaultInjectionGraph(Class<T> type, RootInjection root) {
        this.type = type;
        this.root = root;
    }

    public T apply(Object... args) {
        Object o = root.apply(args);
        return type.cast(o);
    }
}
