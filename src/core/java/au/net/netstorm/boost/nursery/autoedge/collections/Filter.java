package au.net.netstorm.boost.nursery.autoedge.collections;

public interface Filter<T> {
    boolean accept(T o);
}
