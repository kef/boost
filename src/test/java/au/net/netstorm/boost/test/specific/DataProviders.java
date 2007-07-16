package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.test.core.SpecificProvider;

public interface DataProviders extends SpecificProvider {
    void add(Class type, DataProvider provider);
}
