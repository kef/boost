package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;

public class DefaultAutoEdger implements AutoEdger {
    ProxySupplier proxier;
    TempMultiNu nu;
    AutoEdgeFactory factory;

    public <E extends Edge<T>, T> E edge(Class<E> edge, T target) {
        ClassLoader loader = edge.getClassLoader();
        AutoEdge<T> impl = factory.newEdge(target);
        Class<?>[] type = { edge };
        Object proxy = proxier.getProxy(loader, type, impl);
        return edge.cast(proxy);
    }

    public <E extends Edge<T>, T> E newEdge(Class<E> edge, Class<T> type, Object... params) {
        T target = nu.nu(type, params);
        return edge(edge, target);
    }
}
