package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

final class ConstructorParameterCountMismatchData extends Primordial implements Data {
    private final String guitar;
    private final Boolean goodPlayer;

    public ConstructorParameterCountMismatchData(String guitar, Boolean goodPlayer) {
        this.guitar = guitar;
        this.goodPlayer = goodPlayer;
    }

    public String getGuitar() {
        return guitar;
    }

    public Boolean isGoodPlayer() {
        return goodPlayer;
    }
}
