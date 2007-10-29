package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.lifecycle.ThreadTestLifecycle;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.DefaultDataProviders;

public abstract class InteractionTestCase extends LifecycleTestCase implements LazyFields {
    public static final Object VOID = MockExpectations.VOID;
    private final MockSupport mocks = new DefaultMockSupport();
    private final DataProviders providers = new DefaultDataProviders();
    public final Provider random = createRandom();
    public final MockExpectations expect = new DefaultMockExpectations(mocks);
    public final AtomTestChecker atom = new DataAtomTestChecker(random);

    public TestLifecycle testLifecycle() {
        return new InteractionTestLifecycle();
    }

    public ThreadTestLifecycle threadTestLifecycle() {
        InteractionTestState state = new DefaultInteractionTestState(mocks, providers, random);
        return new InteractionThreadTestLifecycle(this, state);
    }

    private Provider createRandom() {
        RandomProviderAssembler assembler = new DefaultRandomProviderAssembler();
        return assembler.everything(providers, mocks);
    }
}
