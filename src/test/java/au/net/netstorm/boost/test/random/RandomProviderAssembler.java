package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.EnumDataProviders;

public interface RandomProviderAssembler {
    Random everything(DataProviders dataProviders, EnumDataProviders enumProviders, MockSupport mocks);
}
