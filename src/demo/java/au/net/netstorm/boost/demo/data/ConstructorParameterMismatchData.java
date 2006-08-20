package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ConstructorParameterMismatchData extends Primordial implements Data {
    private final Integer iq;

    public ConstructorParameterMismatchData(Integer iq) {
        this.iq = iq;
    }

    public Integer getIq() {
        return iq;
    }
}
