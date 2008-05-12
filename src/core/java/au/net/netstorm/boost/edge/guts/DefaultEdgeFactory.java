package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.nursery.type.core.Types;

//FIX 2328 incorporate eager edge validator
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
