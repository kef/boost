package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ExtraPublicMethodsIllegalData extends Primordial implements Data {
    private String guitar;

    public ExtraPublicMethodsIllegalData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }

    public void anExtraMethod() {
    }
}
