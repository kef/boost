package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdgeFactory {
    <T> AutoEdge<T> newEdge(T t);
}
