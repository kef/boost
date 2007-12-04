package au.net.netstorm.boost.test.marker;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface ProvidesData {
    void register(DataProviders dataProviders, Random random);
}
