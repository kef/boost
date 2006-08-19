package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

final class DefaultBooleanBasicData extends Primordial implements Data {
    private final boolean goodPlayer;

    public DefaultBooleanBasicData(boolean goodPlayer) {
        this.goodPlayer = goodPlayer;
    }

    public boolean isGoodPlayer() {
        return goodPlayer;
    }
}
