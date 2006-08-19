package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class PropertyReturnTypeMismatchData extends Primordial implements Data {
    private final String guitar;

    public PropertyReturnTypeMismatchData(String guitar) {
        this.guitar = guitar;
    }

    public int getGuitar() {
        return guitar.length();
    }
}
