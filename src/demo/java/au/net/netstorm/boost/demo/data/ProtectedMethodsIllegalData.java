package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX SC600 Ensure all test data classes are package private.
final class ProtectedMethodsIllegalData extends Primordial implements Data {
    private final String guitar;

    public ProtectedMethodsIllegalData(String guitar) {
        this.guitar = guitar;
    }

    protected String getGuitar() {
        return guitar;
    }
}
