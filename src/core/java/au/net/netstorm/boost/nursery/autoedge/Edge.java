package au.net.netstorm.boost.nursery.autoedge;

public interface Edge<R> {
    // FIX 2328 MAG The commander (POK) suggested any usages of this represent a smell.  Review.
    R unedge();
}
