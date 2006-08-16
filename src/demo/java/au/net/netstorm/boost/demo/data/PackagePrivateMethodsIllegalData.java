package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class PackagePrivateMethodsIllegalData extends Primordial implements Data {
    private final String guitar;

    public PackagePrivateMethodsIllegalData(String guitar) {
        this.guitar = guitar;
    }

    String getGuitar() {
        return guitar;
    }
}
