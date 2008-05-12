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

    // FIX 2328 opinions on this? not the most elegant, but it keeps the code fairly clean
    public <O extends Edge, E extends O> E cast(Class<E> edge, O oldEdge) {
        Class<?> realClass = mapper.edgeToReal(edge);
        return edger.cast(edge, realClass, oldEdge);
    }

    public <E extends Edge> E nu(Class<E> edge, Object... params) {
        Class<?> realClass = mapper.edgeToReal(edge);
        Object real = realNu.nu(realClass, params);
        return edger.nu(edge, realClass, real);
    }

    public <E extends Edge> E nee(Class<E> edge, Class<?> impl, Object... params) {
        Object real = realNu.nu(impl, params);
        Class<?> realClass = mapper.edgeToReal(edge);
        return edger.nu(edge, realClass, real);
    }
}
