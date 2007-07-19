package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultBasicInterface extends Primordial implements BasicInterface {
    private final String guitar;

    public DefaultBasicInterface(String guitar) {
        this.guitar = guitar;
        if (this.guitar == null) throw new IllegalArgumentException();
    }

    public String getGuitar() {
        return guitar;
    }
}