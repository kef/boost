package au.net.netstorm.boost.test.marker;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.specific.DataDataProviders;
import au.net.netstorm.boost.test.specific.EnumDataProviders;

public interface ProvidesData {
    void register(DataDataProviders dataProviders, EnumDataProviders enumProviders, Random random);
}
