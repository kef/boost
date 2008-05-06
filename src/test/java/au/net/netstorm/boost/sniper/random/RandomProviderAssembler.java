package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.gunge.provider.Random;
import au.net.netstorm.boost.sniper.automock.MockSupport;
import au.net.netstorm.boost.sniper.specific.DataProviders;
import au.net.netstorm.boost.sniper.specific.EnumProvider;

public interface RandomProviderAssembler {
    Random everything(DataProviders dataProviders, EnumProvider enumProviders, MockSupport mocks);
}
