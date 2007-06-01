package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultFlavour extends Primordial implements Flavour {
    private final String value;

    public DefaultFlavour(String value) {
        if (value == null) throw new IllegalArgumentException();
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
