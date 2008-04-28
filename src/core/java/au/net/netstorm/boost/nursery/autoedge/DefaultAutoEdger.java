package au.net.netstorm.boost.nursery.autoedge;

import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;

public class DefaultAutoEdger implements AutoEdger {
    ProxySupplier proxier;
    AutoEdgeFactory factory;

    public <E, T> E edge(Class<E> edge, T target) {
        ClassLoader loader = edge.getClassLoader();
        AutoEdge<T> impl = factory.newEdge(target);
        Class<?>[] type = { edge, Edge.class };
        Object proxy = proxier.getProxy(loader, type, impl);
        return edge.cast(proxy);
    }

    // FIXME-MH need to fix this up, it may need an unchecked (or external) cast, but need to check fail cases
    @SuppressWarnings("unchecked")
    public <E, T> T unedge(E candidate) {
        if (!(candidate instanceof Edge)) throw new IllegalArgumentException("Can only unendge an edged class.");
        Edge<T> edge = (Edge<T>) candidate;
        return edge.unedge();
    }
}
