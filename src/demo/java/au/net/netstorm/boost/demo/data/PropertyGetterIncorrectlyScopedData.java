package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class PropertyGetterIncorrectlyScopedData extends Primordial implements Data {
    private final String guitar;

    {  // To keep the code inspector off our back.
        getGuitar();
    }

    public PropertyGetterIncorrectlyScopedData(String guitar) {
        this.guitar = guitar;
    }

    private String getGuitar() {
        return guitar;
    }
}
