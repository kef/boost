package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdger implements AutoEdger {
    ProxySupplier proxier;
    RealNu realNu;
    Nu nu;

    public <E extends Edge<R>, R> E edge(Class<E> edge, R real) {
        ClassLoader loader = edge.getClassLoader();
        AutoEdge handler = nu.nu(DefaultAutoEdge.class, real);
        Class<?>[] type = {edge};
        Object proxy = proxier.getProxy(loader, type, handler);
        return edge.cast(proxy);
    }

    @SuppressWarnings("unchecked")
    public <E extends Edge<R>, R> E nu(Class<E> edge, Object... params) {
        R real = realNu.nu(edge, params);
        return edge(edge, real);
    }
}
