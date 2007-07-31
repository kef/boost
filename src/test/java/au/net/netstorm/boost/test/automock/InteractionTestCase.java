package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.DefaultDataProviders;

public abstract class InteractionTestCase extends LifecycleTestCase implements LazyFields {
    private final MockSupport mocks = new DefaultMockSupport();
    private final DataProviders data = new DefaultDataProviders();
    public final Provider random = createRandom();
    public final MockExpectations expect = new DefaultMockExpectations(mocks);

    public TestLifecycle testLifecycle() {
        InteractionTestState state = new DefaultInteractionTestState(mocks, data, random);
        return new InteractionTestLifecycle(this, state);
    }

    private Provider createRandom() {
        RandomProviderAssembler assembler = new DefaultRandomProviderAssembler();
        return assembler.everything(data, mocks);
    }
}
