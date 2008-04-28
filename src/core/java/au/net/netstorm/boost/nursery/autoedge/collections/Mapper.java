package au.net.netstorm.boost.nursery.autoedge.collections;

public interface Mapper<S,T> {
    T map(S src);
}
