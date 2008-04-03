package au.net.netstorm.boost.gunge.marker;

import au.net.netstorm.boost.gunge.specific.DataProviders;
import au.net.netstorm.boost.gunge.specific.EnumProvider;
import au.net.netstorm.boost.provider.Random;

// FIX ()   2237 This is not a marker interface.
public interface ProvidesData {
    void register(DataProviders dataProviders, EnumProvider enumProviders, Random random);
}
