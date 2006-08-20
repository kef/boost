package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BasicData extends Primordial implements Data {
    private final String guitar;

    public BasicData(String guitar) {
        this.guitar = guitar;
        validate();
    }

    public String getGuitar() {
        return guitar;
    }

    private void validate() {
        if (guitar == null) throw new IllegalArgumentException();
    }
}
