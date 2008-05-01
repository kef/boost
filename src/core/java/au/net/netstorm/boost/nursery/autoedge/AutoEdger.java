package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdger {
    <E extends Edge<R>, R> E edge(Class<E> edge, R target);

    <E extends Edge<R>, R> E newEdge(Class<E> edge, Object... params);
}
