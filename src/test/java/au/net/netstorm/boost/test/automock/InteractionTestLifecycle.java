package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.specific.BoostDataProviders;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;
import au.net.netstorm.boost.test.validate.TestClassValidator;
import au.net.netstorm.boost.test.validate.Validator;

public final class InteractionTestLifecycle implements TestLifecycle {
    private final TestFieldInjector testFieldInjector;
    private final InteractionTestCase testCase;
    private final Provider random;
    private final DataProviders dataProviders;
    private final Validator validator = new TestClassValidator();

    public InteractionTestLifecycle(InteractionTestCase testCase, InteractionTestState state) {
        this.testCase = testCase;
        random = state.getRandom();
        dataProviders = state.getDataProviders();
        MockSupport mocks = state.getMockSupport();
        testFieldInjector = new DefaultTestFieldInjector(testCase, mocks, random);
    }

    public void pre() {
        doValidate();
        doRegisterDataProviders();
        doInjectLazyFields();
        doInitialise();
        doSetupSubject();
        doInjectSubject();
    }

    public void run() throws Throwable {
        testCase.runTest();
    }

    public void post() {
        // Hook in from jMock.  Needed for jMock to actually verify.
        testFieldInjector.verify();
    }

    public void cleanup(boolean successful) {
        doDestroy();
    }

    private void doValidate() {
        validator.validate(testCase);
    }

    private void doRegisterDataProviders() {
        ProvidesData baseProviders = new BoostDataProviders(random);
        baseProviders.register(dataProviders);
        if (hasMarker(ProvidesData.class)) ((ProvidesData) testCase).register(dataProviders);
    }

    private void doInjectSubject() {
        if (hasMarker(InjectableSubject.class)) testFieldInjector.injectSubject();
    }

    private void doDestroy() {
        if (hasMarker(Destroyable.class)) ((Destroyable) testCase).destroy();
    }

    private void doInitialise() {
        if (hasMarker(Constructable.class)) ((Constructable) testCase).constructor();
    }

    private void doSetupSubject() {
        if (hasMarker(HasFixtures.class)) ((HasFixtures) testCase).setUpFixtures();
    }

    private void doInjectLazyFields() {
        if (hasMarker(LazyFields.class)) testFieldInjector.inject();
    }

    private boolean hasMarker(Class marker) {
        Class cls = testCase.getClass();
        return marker.isAssignableFrom(cls);
    }
}
