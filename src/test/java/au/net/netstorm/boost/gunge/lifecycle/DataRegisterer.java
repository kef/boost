package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.core.Test;
import au.net.netstorm.boost.gunge.marker.ProvidesData;
import au.net.netstorm.boost.gunge.specific.DataProviders;
import au.net.netstorm.boost.gunge.specific.EnumProvider;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.util.type.Marker;

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
