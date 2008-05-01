package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdger implements AutoEdger {
    EdgeValidator validator;
    ProxySupplier proxier;
    RealNu realNu;
    Nu nu;

    public <E extends Edge<R>, R> E edge(Class<E> edge, R real) {
        return createEdge(edge, real.getClass(), real);
    }

    public <E extends Edge<R>, R> E nu(Class<E> edge, Object... params) {
        R real = realNu.nu(edge, params);
        return edge(edge, real);
    }

    private <E> E createEdge(Class<E> edge, Class<?> realClass, Object real) {
        AutoEdge handler = nu.nu(DefaultAutoEdge.class, real);
        validator.validate(edge);
        ClassLoader loader = edge.getClassLoader();
        Class<?>[] type = {edge};
        Object proxy = proxier.getProxy(loader, type, handler);
        return edge.cast(proxy);
    }
}
