package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface RandomProviderAssembler {
    Random everything(DataProviders dataProviders, MockSupport mocks);
}
