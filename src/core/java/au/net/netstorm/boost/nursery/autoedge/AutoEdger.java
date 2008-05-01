package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdger {
    <E extends Edge<R>, R> E edge(Class<E> edge, R real);

    <E extends StaticEdge<R>, R> E edge(Class<E> edge);

    <E extends Edge<R>, R> E nu(Class<E> edge, Object... params);
}
