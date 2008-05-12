package au.net.netstorm.boost.edge.core;



public interface AutoEdger {
    <E extends Edge> E edge(Class<E> edge, Object real);

    <E extends Edge> E edge(Class<E> edge);

    <O extends Edge, E extends O> E cast(Class<E> edge, O oldEdge);

    <E extends Edge> E nu(Class<E> edge, Object... params);

    <E extends Edge> E nee(Class<E> edge, Class<?> impl, Object... params);
}
