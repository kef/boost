package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.nursery.type.core.Types;

public final class DefaultEdgeFactory implements EdgeFactory {
    ProxySupplier proxier;
    Types types;

    public <E extends Edge> E nu(Class<E> edgeClass, Class<?> realClass, Object real) {
        Object proxy = nuEdgeProxy(edgeClass, realClass, real);
        return edgeClass.cast(proxy);
    }

    // FIX 2328 not sure that it such a good idea
    public <O extends Edge, E extends O> E cast(Class<E> edgeClass, Class<?> realClass, O edge) {
        // FIX 2328 intentional whole in typing, could be checked, but I think not, would require too much effort
        // FIX 2328 for it to get stuffed up to that point, and it is going to fail anyway
        Unedgable unedgable = (Unedgable) edge;
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
