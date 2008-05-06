package au.net.netstorm.boost.edge;

interface RealNu {
    <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs);
}
