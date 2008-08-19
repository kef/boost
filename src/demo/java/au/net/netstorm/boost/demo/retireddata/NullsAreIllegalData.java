package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.LooseData;

final class NullsAreIllegalData extends Primordial implements Data, LooseData {
    private final String guitar;

    public NullsAreIllegalData(String guitar) {
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }
}
