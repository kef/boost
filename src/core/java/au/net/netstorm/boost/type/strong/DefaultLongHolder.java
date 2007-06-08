package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultLongHolder extends Primordial implements LongHolder {
    private final long value;

    public DefaultLongHolder(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
