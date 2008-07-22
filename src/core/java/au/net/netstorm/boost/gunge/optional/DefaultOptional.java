package au.net.netstorm.boost.gunge.optional;

public final class DefaultOptional<T> implements Optional<T> {
    private T t;

    public DefaultOptional(T t) {
        validate(t);
        this.t = t;
    }

    public boolean isSet() {
        return true;
    }

    public T get() {
        return t;
    }

    private void validate(Object o) {
        if (o == null) throw new IllegalArgumentException("DefaultOptional can not be null. Use NotSet.");
    }
}
