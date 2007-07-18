package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class BoostDataProviders implements ProvidesData {
    private final Provider random;

    public BoostDataProviders(Provider random) {
        this.random = random;
    }

    public void register(DataProviders data) {
        data.add(Interface.class, new InterfaceProvider());
        data.add(Implementation.class, new ImplementationProvider());
        data.add(TimePoint.class, new TimePointProvider(random));
    }
}
