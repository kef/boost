package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class MultipleConstructorIllegalData extends Primordial implements Data {
    private final int tune;

    public MultipleConstructorIllegalData(int iq) {
        this.tune = iq;
    }

    public MultipleConstructorIllegalData() {
        tune = 10;
    }

    public int getTune() {
        return tune;
    }
}
