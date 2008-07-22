package au.net.netstorm.boost.gunge.optional;

// FIX 2394 Use or lose. Use case is Optional<Provider>.
public interface Optional<T> {
    boolean isSet();
    T get();
}
