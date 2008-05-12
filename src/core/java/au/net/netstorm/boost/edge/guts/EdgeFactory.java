package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.Edge;

public interface EdgeFactory {
    <E extends Edge> E nu(Class<E> edgeClass, Class<?> realClass, Object real);

    <O extends Edge, E extends O> E cast(Class<E> edge, Class<?> realClass, O oldEdge);
}
