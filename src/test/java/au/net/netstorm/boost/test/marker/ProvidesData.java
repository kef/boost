package au.net.netstorm.boost.test.marker;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.EnumProvider;

public interface ProvidesData {
    void register(DataProviders dataProviders, EnumProvider enumProviders, Random random);
}
