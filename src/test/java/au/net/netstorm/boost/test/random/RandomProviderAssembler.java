package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface RandomProviderAssembler {
    Provider everything(DataProviders registry);

    Provider everything(DataProviders dataProviders, AutoMocker mocker);
}
