package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultIntegerHolder extends Primordial implements IntegerHolder {
    private final int value;

    public DefaultIntegerHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
