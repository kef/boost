package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.Test;
import au.net.netstorm.boost.test.marker.ProvidesData;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.util.type.Marker;

public final class DataRegisterer implements TestLifecycleBlock {
    DataProviders data;
    Provider random;
    Test test;
    Marker marker;

    public void execute() {
        if (marker.is(test, ProvidesData.class)) ((ProvidesData) test).register(data, random);
    }
}
