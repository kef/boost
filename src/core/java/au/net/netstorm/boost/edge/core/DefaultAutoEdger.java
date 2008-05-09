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

    public <E, R> E edge(Class<E> edge, R real) {
        Class<?> realClass = real.getClass();
        return createEdge(edge, realClass, real, false);
    }

    public <E> E edge(Class<E> edge) {
        Class<?> realClass = mapper.staticEdgeToReal(edge);
        return createEdge(edge, realClass, null, true);
    }

    // FIX 2328 Put in test for extra method (use SDF and DateFormat as driver).
    // FIX 2328 need a second nu method which allows concrete subclasses to be specified, rather than implied
    public <E extends Edge> E nu(Class<E> edge, Object... params) {
        Class<?> realClass = mapper.edgeToReal(edge);
        Object real = realNu.nu(realClass, params);
        return createEdge(edge, realClass, real, false);
    }

    // FIX 2328 add in call to validator
    private <R, E> E createEdge(Class<E> edgeClass, Class<?> realClass, R real, boolean staticy) {
        validator.validate(edgeClass, realClass, staticy);
        return edger.nu(edgeClass, realClass, real);
    }
}
