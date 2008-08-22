package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.InterfaceMaster;
import au.net.netstorm.boost.scalpel.core.Edge;
import au.net.netstorm.boost.scalpel.core.Unedgable;
import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultEdgeFactory implements EdgeFactory {
    LayerFactory layers;
    InterfaceMaster interfaces;
    Nu nu;

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
        Class[] types = {edgeClass, Unedgable.class};
        Interface[] ifaces = interfaces.interfaces(types);
        AutoEdge handler = nu.nu(AutoEdge.class, realClass, real);
        return layers.newProxy(ifaces, handler);
    }
}
