package au.net.netstorm.boost.nursery.autoedge;

interface RealNu {
    <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs);
}
