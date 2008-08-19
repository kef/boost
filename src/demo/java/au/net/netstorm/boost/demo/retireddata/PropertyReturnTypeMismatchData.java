package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class PropertyReturnTypeMismatchData extends Primordial implements Data {
    private final String guitar;

    public PropertyReturnTypeMismatchData(String guitar) {
        this.guitar = guitar;
    }

    public int getGuitar() {
        return guitar.length();
    }
}
