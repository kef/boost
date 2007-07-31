package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface RandomProviderAssembler {
    Provider everything(DataProviders dataProviders, MockSupport mocks);
}
