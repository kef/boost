package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.primordial.Primordial;

public class EstesRocket extends Primordial implements Rocket {
    private Fin fins;
    private Nose nose;

    public EstesRocket(Fin fins, Nose nose) {
        this.fins = fins;
        this.nose = nose;
    }

    public Fin getFin() {
        return fins;
    }

    public Nose getNose() {
        return nose;
    }
}
