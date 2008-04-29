package au.net.netstorm.boost.nursery.autoedge.collections;

public interface Finder<T> {
    boolean next(T o);
    T result();
}
