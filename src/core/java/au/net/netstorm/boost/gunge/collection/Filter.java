package au.net.netstorm.boost.gunge.collection;

public interface Filter<T> {
    boolean accept(T o);
}
