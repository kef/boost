package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.primordial.Primordial;

public class RealCentipede extends Primordial implements Centipede {
    private final String name;
    private final int numLegs;

    public RealCentipede(String name, int numLegs) {
        this.name = name;
        this.numLegs = numLegs;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public String getName() {
        return name;
    }
}
