package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface EdgeFactory {
    <E extends Edge> E nu(Class<E> edgeClass, Class<?> realClass, Object real);

    <O extends Edge, E extends O> E cast(Class<E> edgeClass, Class<?> realClass, O oldEdge);
}
