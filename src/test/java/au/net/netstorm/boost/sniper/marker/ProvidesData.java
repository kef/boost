package au.net.netstorm.boost.sniper.marker;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.EnumProvider;

// FIX ()   2237 This is not a marker interface.
public interface ProvidesData {
    void register(DataProviders dataProviders, EnumProvider enumProviders, Random random);
}
