package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class PublicStaticMethodsIllegalData extends Primordial implements Data {
    private static String guitar;

    public PublicStaticMethodsIllegalData(String guitar) {
        PublicStaticMethodsIllegalData.guitar = guitar;
    }

    public static String getGuitar() {
        return guitar;
    }
}
