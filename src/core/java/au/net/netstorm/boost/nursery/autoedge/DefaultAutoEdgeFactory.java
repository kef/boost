package au.net.netstorm.boost.nursery.autoedge;

public class DefaultAutoEdgeFactory implements AutoEdgeFactory {
    MethodWarp warp;
    public <T> AutoEdge<T> newEdge(T t) {
        return new DefaultAutoEdge<T>(t, warp);
    }
}
