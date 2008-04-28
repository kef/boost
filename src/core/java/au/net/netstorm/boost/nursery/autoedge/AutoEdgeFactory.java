package au.net.netstorm.boost.nursery.autoedge;

public interface AutoEdgeFactory {
    // nu instead of newEdge?
    <T> AutoEdge<T> newEdge(T t);
}
