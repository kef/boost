package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class MethodWithArgumentsIllegalData extends Primordial implements Data {
    private String guitar;

    public MethodWithArgumentsIllegalData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar(String broken) {
        return guitar;
    }
}
