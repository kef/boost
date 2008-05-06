package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.bullet.time.core.TimePoint;
import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.marker.ProvidesData;

public final class BoostDataProviders implements ProvidesData {
    public void register(DataProviders data, EnumProvider enums, Random random) {
        data.add(Interface.class, new InterfaceProvider());
        data.add(Implementation.class, new ImplementationProvider());
        data.add(TimePoint.class, new TimePointProvider(random));
    }
}
