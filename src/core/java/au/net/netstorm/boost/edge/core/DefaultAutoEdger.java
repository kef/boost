package au.net.netstorm.boost.edge.core;

import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.EdgeMapper;
import au.net.netstorm.boost.edge.guts.RealNu;

public final class DefaultAutoEdger implements AutoEdger {
    EdgeFactory edger;
    EdgeMapper mapper;
    RealNu realNu;

    public <E extends Edge> E edge(Class<E> edge, Object real) {
        Class<?> realClass = mapper.edgeToReal(edge);
        return edger.nu(edge, realClass, real);
    }

    public <E extends Edge> E edge(Class<E> edge) {
        Class<?> realClass = mapper.staticEdgeToReal(edge);
        return edger.nu(edge, realClass, null);
    }

    // FIX 2328 i think the simplest solution is going to be add, an edge cast
    // FIX 2328 not the most attractive solution, but it is pretty simple to implement
    // FIX 2328 and can be refined/hidden later, with the exception of JCA (and even then
    // FIX 2328 it is only things to do with certs), APIs that do not return the most specific
    // FIX 2328 type and require check and cast code will have to use the cast method
    public <O extends Edge, E extends O> E cast(Class<E> edge, O oldEdge) {
        Class<?> realClass = mapper.edgeToReal(edge);
        return edger.cast(edge, realClass, oldEdge);
    }

    public <E extends Edge> E nu(Class<E> edge, Object... params) {
        Class<?> realClass = mapper.edgeToReal(edge);
        Object real = realNu.nu(realClass, params);
        return edger.nu(edge, realClass, real);
    }

    public <E extends Edge> E nuImpl(Class<E> edge, Class<?> impl, Object... params) {
        Object real = realNu.nu(impl, params);
        Class<?> realClass = mapper.edgeToReal(edge);
        return edger.nu(edge, realClass, real);
    }
}
