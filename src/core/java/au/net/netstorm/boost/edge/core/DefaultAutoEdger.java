package au.net.netstorm.boost.edge.core;

import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.EdgeMapper;
import au.net.netstorm.boost.edge.guts.EdgeValidator;
import au.net.netstorm.boost.edge.guts.RealNu;

public final class DefaultAutoEdger implements AutoEdger {
    EdgeFactory edger;
    EdgeMapper mapper;
    RealNu realNu;
    EdgeValidator validator;

    // FIX 2328 need to really rethink what class i want as real, is it impl or real edge
    // FIX 2328 same decision to be made for the nuImpl method
    public <E extends Edge> E edge(Class<E> edge, Object real) {
        Class<?> realClass = mapper.edgeToReal(edge);
        return createEdge(edge, realClass, real, false);
    }

    public <E extends Edge> E edge(Class<E> edge) {
        Class<?> realClass = mapper.staticEdgeToReal(edge);
        return createEdge(edge, realClass, null, true);
    }

    public <E extends Edge> E nu(Class<E> edge, Object... params) {
        Class<?> realClass = mapper.edgeToReal(edge);
        Object real = realNu.nu(realClass, params);
        return createEdge(edge, realClass, real, false);
    }

    public <E extends Edge> E nuImpl(Class<E> edge, Class<?> impl, Object... params) {
        Object real = realNu.nu(impl, params);
        Class<?> realClass = mapper.edgeToReal(edge);
        return createEdge(edge, realClass, real, false);
    }

    private <R, E> E createEdge(Class<E> edgeClass, Class<?> realClass, R real, boolean staticy) {
        validator.validate(edgeClass, realClass, staticy);
        return edger.nu(edgeClass, realClass, real);
    }
}
