package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.marker.ProvidesData;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class BoostDataProviders implements ProvidesData {
    public void register(DataDataProviders dataProviders, EnumDataProviders enumProviders, Random random) {
        dataProviders.add(Interface.class, new InterfaceProvider());
        dataProviders.add(Implementation.class, new ImplementationProvider());
        dataProviders.add(TimePoint.class, new TimePointProvider(random));
    }
}
