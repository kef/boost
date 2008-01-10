package au.net.netstorm.boost.test.marker;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.EnumProvider;

// FIX ()   2237 This is not a marker interface.
public interface ProvidesData {
    void register(DataProviders dataProviders, EnumProvider enumProviders, Random random);
}
