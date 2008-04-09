package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ProtectedMethodsIllegalData extends Primordial implements Data {
    private final String guitar;

    public ProtectedMethodsIllegalData(String guitar) {
        this.guitar = guitar;
    }

    protected String getGuitar() {
        return guitar;
    }
}
