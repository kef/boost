package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdger implements AutoEdger {
    ProxySupplier proxier;
    TempMultiNu multiNu;
    TypeTokenResolver typeResolver;
    Nu nu;

    public <E extends Edge<T>, T> E edge(Class<E> edge, T target) {
        ClassLoader loader = edge.getClassLoader();
        AutoEdge impl = nu.nu(DefaultAutoEdge.class, target);
        Class<?>[] type = {edge};
        Object proxy = proxier.getProxy(loader, type, impl);
        return edge.cast(proxy);
    }

    @SuppressWarnings("unchecked")
    public <E extends Edge<T>, T> E newEdge(Class<E> edge, Object... params) {
        TypeTokenInstance typeToken = typeResolver.resolve(Edge.class, edge);
        Class<T> type = (Class<T>) typeToken.rawType();
        T target = multiNu.nu(type, params);
        return edge(edge, target);
    }
}
