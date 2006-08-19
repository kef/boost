package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BasicNonFinalFieldsData extends Primordial implements Data {
    private String guitar;

    public BasicNonFinalFieldsData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }
}
