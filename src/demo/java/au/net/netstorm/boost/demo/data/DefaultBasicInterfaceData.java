package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class DefaultBasicInterfaceData extends Primordial implements Data, BasicInterface {
    private final String guitar;

    public DefaultBasicInterfaceData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }
}
