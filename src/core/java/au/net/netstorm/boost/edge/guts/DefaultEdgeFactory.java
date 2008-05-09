package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.nursery.type.core.Types;

public final class DefaultEdgeFactory implements EdgeFactory {
    EdgeValidator validator;
    ProxySupplier proxier;
    Types types;

    public <E> E nu(Class<E> edgeClass, Class<?> realClass, Object real) {
        validator.validate(edgeClass, realClass);
        Object proxy = nuEdgeProxy(edgeClass, realClass, real);
        // FIX 2328 is CCE ok or should i check throw illegal arg
        return edgeClass.cast(proxy);
    }

    private <E> Object nuEdgeProxy(Class<E> edgeClass, Class<?> realClass, Object real) {
        ClassLoader loader = edgeClass.getClassLoader();
        Class<?>[] type = {edgeClass, Unedgable.class};
        AutoEdge handler = types.nu(AutoEdge.class, realClass, real);
        return proxier.getProxy(loader, type, handler);
    }
}
