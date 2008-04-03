package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.gunge.automock.MockSupport;
import au.net.netstorm.boost.gunge.specific.DataProviders;
import au.net.netstorm.boost.gunge.specific.EnumProvider;
import au.net.netstorm.boost.provider.Random;

public interface RandomProviderAssembler {
    Random everything(DataProviders dataProviders, EnumProvider enumProviders, MockSupport mocks);
}
