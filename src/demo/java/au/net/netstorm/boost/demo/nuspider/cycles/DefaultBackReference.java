package au.net.netstorm.boost.demo.nuspider.cycles;

import au.net.netstorm.boost.demo.nuspider.cycles.Cyclic;
import au.net.netstorm.boost.demo.nuspider.cycles.BackReference;

public final class DefaultBackReference implements BackReference {
    Cyclic cyclic;

    public Cyclic get() {
        return cyclic;
    }
}
