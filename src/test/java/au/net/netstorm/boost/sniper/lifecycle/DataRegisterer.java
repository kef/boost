package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.bullet.provider.Random;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.sniper.core.Test;
import au.net.netstorm.boost.sniper.marker.ProvidesData;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.EnumProvider;

public final class DataRegisterer implements TestLifecycleBlock {
    DataProviders data;
    EnumProvider enums;
    Random random;
    Test test;
    Marker marker;

    public void execute() {
        if (marker.is(test, ProvidesData.class)) ((ProvidesData) test).register(data, enums, random);
    }
}
