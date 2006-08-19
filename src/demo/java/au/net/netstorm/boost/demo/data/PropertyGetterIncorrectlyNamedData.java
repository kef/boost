package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class PropertyGetterIncorrectlyNamedData extends Primordial implements Data {
    private final String guitar;

    public PropertyGetterIncorrectlyNamedData(String guitar) {
        this.guitar = guitar;
    }

    public String getOboe() {
        return guitar;
    }
}
