package au.net.netstorm.boost.edge.core;

import au.net.netstorm.boost.edge.guts.ClassWarper;
import au.net.netstorm.boost.edge.guts.EdgeFactory;
import au.net.netstorm.boost.edge.guts.RealNu;

public final class DefaultAutoEdger implements AutoEdger {
    EdgeFactory edger;
    ClassWarper warper;
    RealNu realNu;

    public <E extends Edge, R> E edge(Class<E> edge, R real) {
        Class<?> realClass = real.getClass();
        return edger.nu(edge, realClass, real);
    }

    public <E extends StaticEdge> E edge(Class<E> edge) {
        Class<?> realClass = warper.edgeToReal(edge);
        return edger.nu(edge, realClass, null);
    }

    // FIX 2328 Put in test for extra method (use SDF and DateFormat as driver).
    // FIX 2328 need a second nu method which allows concrete subclasses to be specified, rather than implied
    public <E extends Edge> E nu(Class<E> edge, Object... params) {
        Class<?> realClass = warper.edgeToReal(edge);
        Object real = realNu.nu(realClass, params);
        return edger.nu(edge, realClass, real);
    }
}
