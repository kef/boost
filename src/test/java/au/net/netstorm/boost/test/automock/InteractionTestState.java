package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.specific.DataProviders;

public interface InteractionTestState {
    MockSupport getMockSupport();

    DataProviders getDataProviders();

    Provider getRandom();
}
