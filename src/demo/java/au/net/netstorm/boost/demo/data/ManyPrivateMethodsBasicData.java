package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ManyPrivateMethodsBasicData extends Primordial implements Data {
    private final String guitar;

    public ManyPrivateMethodsBasicData(String guitar) {
        this.guitar = guitar;
        doSomeStuff();
        validate();
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

    private void validate() {
        if (guitar == null) throw new IllegalArgumentException();
    }
}
