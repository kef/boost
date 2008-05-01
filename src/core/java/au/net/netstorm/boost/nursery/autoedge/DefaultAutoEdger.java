package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdger implements AutoEdger {
    ProxySupplier proxier;
    EdgeNu edgeNu;
    TypeTokenResolver typeResolver;
    Nu nu;

    public <E extends Edge<R>, R> E edge(Class<E> edge, R target) {
        ClassLoader loader = edge.getClassLoader();
        AutoEdge impl = nu.nu(DefaultAutoEdge.class, target);
        Class<?>[] type = {edge};
        Object proxy = proxier.getProxy(loader, type, impl);
        return edge.cast(proxy);
    }

    @SuppressWarnings("unchecked")
    public <E extends Edge<R>, R> E nu(Class<E> edge, Object... params) {
        TypeTokenInstance typeToken = typeResolver.resolve(Edge.class, edge);
        Class<R> type = (Class<R>) typeToken.rawType();
        R target = edgeNu.nu(type, params);
        return edge(edge, target);
    }
}
