package au.net.netstorm.boost.nursery.autoedge;


interface AutoEdgeBuilder {
    <E extends StaticEdge<R>, R> AutoEdge nu(Class<E> edge);
    <E extends Edge<R>, R> AutoEdge nu(Class<E> edge, R real);
}
