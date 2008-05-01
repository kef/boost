package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeTokenInstance;
import au.net.netstorm.boost.gunge.generics.TypeTokenResolver;
import au.net.netstorm.boost.spider.instantiate.Nu;

public final class DefaultAutoEdger implements AutoEdger {
    TypeTokenResolver typeResolver;
    EdgeValidator validator;
    ProxySupplier proxier;
    RealNu realNu;
    Nu nu;

    public <E extends Edge<R>, R> E edge(Class<E> edge, R real) {
        return createEdge(edge, real.getClass(), real);
    }

    public <E extends StaticEdge<R>, R> E edge(Class<E> edge) {
        TypeTokenInstance typeToken = typeResolver.resolve(StaticEdge.class, edge);
        return createEdge(edge, typeToken.rawType(), null);
    }

    public <E extends Edge<R>, R> E nu(Class<E> edge, Object... params) {
        R real = realNu.nu(edge, params);
        return edge(edge, real);
    }

    // FIX 2328 realClass not used?  Remove and follow out.
    // FIX 2328 Mark I'm going to assume you need realClass for something.
    // FIX 2328 Cause if you don't TTR field goes (and maybe TTR).
    private <E> E createEdge(Class<E> edge, Class<?> realClass, Object real) {
        AutoEdge handler = nu.nu(DefaultAutoEdge.class, real);
        validator.validate(edge);
        ClassLoader loader = edge.getClassLoader();
        Class<?>[] type = {edge};
        Object proxy = proxier.getProxy(loader, type, handler);
        return edge.cast(proxy);
    }
}
