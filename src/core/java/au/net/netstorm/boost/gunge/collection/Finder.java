package au.net.netstorm.boost.gunge.collection;

public interface Finder<T> {
    boolean next(T o);
    T result();
}
