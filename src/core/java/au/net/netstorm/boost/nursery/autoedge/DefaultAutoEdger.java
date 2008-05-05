package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.gunge.generics.TypeInstance;
import au.net.netstorm.boost.gunge.generics.TypeResolver;
import au.net.netstorm.boost.nursery.type.core.Types;

public final class DefaultAutoEdger implements AutoEdger {
    TypeResolver typeResolver;
    EdgeValidator validator;
    ProxySupplier proxier;
    RealNu realNu;
    Types types;

    public <E extends Edge<R>, R> E edge(Class<E> edge, R real) {
        Class<?> realClass = real.getClass();
        return createEdge(edge, realClass, real);
    }

    public <E extends StaticEdge<R>, R> E edge(Class<E> edge) {
        TypeInstance typeToken = typeResolver.resolve(edge, StaticEdge.class);
        Class<?> realClass = typeToken.raw();
        return createEdge(edge, realClass, null);
    }

    public <E extends Edge<R>, R> E nu(Class<E> edge, Object... params) {
        R real = realNu.nu(edge, params);
        return edge(edge, real);
    }

    // FIX 2328 Bit big?
    private <E> E createEdge(Class<E> edgeClass, Class<?> realClass, Object real) {
        validator.validate(edgeClass, realClass);
        ClassLoader loader = edgeClass.getClassLoader();
        Class<?>[] type = {edgeClass};
        AutoEdge handler = types.nu(AutoEdge.class, realClass, real);
        Object proxy = proxier.getProxy(loader, type, handler);
        return edgeClass.cast(proxy);
    }
}
