package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultStringHolder extends Primordial implements StringHolder {
    private final String value;

    public DefaultStringHolder(String value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
