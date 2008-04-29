package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdger {
    <E extends Edge<T>, T> E edge(Class<E> edge, T target);
    // TODO-MH could infer target type from edge type using gafters gadget
    <E extends Edge<T>, T> E newEdge(Class<E> edge, Class<T> target, Object... params);
}
