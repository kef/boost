package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class ConstructorParameterCountMismatchData extends Primordial implements Data {
    private final String guitar;
    private final boolean goodPlayer;

    public ConstructorParameterCountMismatchData(String guitar, boolean goodPlayer) {
        this.guitar = guitar;
        this.goodPlayer = goodPlayer;
    }

    public String getGuitar() {
        return guitar;
    }

    public boolean isGoodPlayer() {
        return goodPlayer;
    }
}
