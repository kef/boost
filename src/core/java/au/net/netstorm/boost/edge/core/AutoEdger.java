package au.net.netstorm.boost.edge.core;

public interface AutoEdger {
    <E, R> E edge(Class<E> edge, R real);

    <E> E edge(Class<E> edge);

    <E extends Edge> E nu(Class<E> edge, Object... params);
}
