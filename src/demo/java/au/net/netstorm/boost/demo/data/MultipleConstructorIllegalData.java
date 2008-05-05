package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class MultipleConstructorIllegalData extends Primordial implements Data {
    private final Integer tune;

    public MultipleConstructorIllegalData(Integer tune) {
        this.tune = tune;
    }

    public MultipleConstructorIllegalData() {
        tune = 10;
    }

    public Integer getTune() {
        return tune;
    }
}
