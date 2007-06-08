package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultBooleanHolder extends Primordial implements BooleanHolder {
    private final boolean troo;

    public DefaultBooleanHolder(boolean troo) {
        this.troo = troo;
    }

    public boolean isTroo() {
        return troo;
    }
}
