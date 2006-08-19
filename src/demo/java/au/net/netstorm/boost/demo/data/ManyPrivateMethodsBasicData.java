package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ManyPrivateMethodsBasicData extends Primordial implements Data, BasicData {
    private final String guitar;

    public ManyPrivateMethodsBasicData(String guitar) {
        doSomeStuff();
        this.guitar = guitar;
    }

    public String getGuitar() {
        return guitar;
    }

    private void doSomeStuff() {
        doSomeMoreStuff();
    }

    private void doSomeMoreStuff() {
        doNothing();
    }

    private void doNothing() {
    }
}
