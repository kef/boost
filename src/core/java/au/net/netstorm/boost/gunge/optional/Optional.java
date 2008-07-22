package au.net.netstorm.boost.gunge.optional;

public interface Optional<T> {
    boolean isSet();
    T get();
}
