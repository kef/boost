package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.SpecificProvider;

public interface DataProviders extends SpecificProvider {
    void add(Class type, DataProvider provider);
}
