package au.net.netstorm.boost.nursery.data;

import au.net.netstorm.boost.bullet.primordial.Primordial;

class RealCentipede extends Primordial implements Centipede {
    private final String name;
    private final Integer numLegs;

    public RealCentipede(String name, int numLegs) {
        this.name = name;
        this.numLegs = numLegs;
    }

    public Integer numLegs() {
        return numLegs;
    }

    public String name() {
        return name;
    }
}
