package au.net.netstorm.boost.edge.core;


public interface AutoEdger {
    <E extends Edge> E edge(Class<E> edge, Object real);

    <E extends Edge> E edge(Class<E> edge);

    <E extends Edge> E nu(Class<E> edge, Object... params);

    <E extends Edge> E nuImpl(Class<E> edge, Class<?> impl, Object... params);
}
