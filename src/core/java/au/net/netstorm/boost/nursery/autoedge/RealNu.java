package au.net.netstorm.boost.nursery.autoedge;


// FIX 2328 Maybe not.  But resolve (ha ha).

// FIX 2328 ideally I would like to see support for multi constructors in regular Nu
interface RealNu {
    <E extends Edge<R>, R> R nu(Class<E> edge, Object... edgedArgs);
}
