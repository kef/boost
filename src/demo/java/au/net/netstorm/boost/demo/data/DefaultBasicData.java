package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class DefaultBasicData extends Primordial implements Data, BasicData {
    private final String guitar;

    public DefaultBasicData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }
}
