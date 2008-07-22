package au.net.netstorm.boost.gunge.optional;

public final class NotSet<T> implements Optional<T> {
    public boolean isSet() {
        return false;
    }

    public T get() {
        throw new IllegalStateException("Optional is not set.");
    }
}
