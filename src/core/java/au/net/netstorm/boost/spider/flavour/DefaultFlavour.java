package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultFlavour extends Primordial implements Flavour {
    private final String value;

    public DefaultFlavour(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        if (value == null) throw new IllegalArgumentException();
    }
}
