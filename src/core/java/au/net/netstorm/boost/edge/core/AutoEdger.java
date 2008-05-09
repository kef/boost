package au.net.netstorm.boost.edge.core;


public interface AutoEdger {
    <E extends Edge> E edge(Class<E> edge, Object real);

    <E extends Edge> E edge(Class<E> edge);

    <E extends Edge> E nu(Class<E> edge, Object... params);

    // FIX 2328 think of a better name - can't be nu because of stupid varargs
    <E extends Edge> E nuImpl(Class<E> edge, Class<?> impl, Object... params);
}
