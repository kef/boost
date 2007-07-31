package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.specific.DataProviders;

public final class DefaultInteractionTestState implements InteractionTestState {
    private final MockSupport mockSupport;
    private final DataProviders dataProviders;
    private final Provider random;

    public DefaultInteractionTestState(MockSupport mocks, DataProviders data, Provider random) {
        this.mockSupport = mocks;
        this.dataProviders = data;
        this.random = random;
    }

    public MockSupport getMockSupport() {
        return mockSupport;
    }

    public DataProviders getDataProviders() {
        return dataProviders;
    }

    public Provider getRandom() {
        return random;
    }
}
