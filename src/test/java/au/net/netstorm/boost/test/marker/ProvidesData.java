package au.net.netstorm.boost.test.marker;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface ProvidesData {
    void register(DataProviders dataProviders, Provider random);
}
