package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BasicData extends Primordial implements Data {
    // FIX SC600 Does not have to be final.
    private final String frog;

    public BasicData(String frog) {
        this.frog = frog;
    }

    public String getFrog() {
        return frog;
    }
}
