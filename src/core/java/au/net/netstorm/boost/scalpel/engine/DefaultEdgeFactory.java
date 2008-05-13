package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.scalpel.core.Edge;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;

//FIX 2328 edge method validation is lazy, is there a case for fail early on method mismatch
public final class DefaultEdgeFactory implements EdgeFactory {
    ProxySupplier proxier;
    Types types;

    public <E extends Edge> E nu(Class<E> edgeClass, Class<?> realClass, Object real) {
        Object proxy = nuEdgeProxy(edgeClass, realClass, real);
        return edgeClass.cast(proxy);
    }

    public <O extends Edge, E extends O> E cast(Class<E> edgeClass, Class<?> realClass, O oldEdge) {
        Unedgable unedgable = (Unedgable) oldEdge;
        Object real = unedgable.unedge();
        Object proxy = nuEdgeProxy(edgeClass, realClass, real);
        return edgeClass.cast(proxy);
    }

    private <E> Object nuEdgeProxy(Class<E> edgeClass, Class<?> realClass, Object real) {
        ClassLoader loader = edgeClass.getClassLoader();
        Class<?>[] type = {edgeClass, Unedgable.class};
        AutoEdge handler = types.nu(AutoEdge.class, realClass, real);
        return proxier.getProxy(loader, type, handler);
    }
}
