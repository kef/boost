package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;

final class DefaultBasicInterfaceData extends Primordial implements BasicInterface {
    private final String guitar;

    public DefaultBasicInterfaceData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }
}
