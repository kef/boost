package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class BooleanBasicData extends Primordial implements Data {
    private final boolean goodPlayer;

    public BooleanBasicData(boolean goodPlayer) {
        this.goodPlayer = goodPlayer;
    }

    public boolean isGoodPlayer() {
        return goodPlayer;
    }
}
