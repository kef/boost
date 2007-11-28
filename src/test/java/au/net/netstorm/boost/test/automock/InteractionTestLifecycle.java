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

public class InteractionTestLifecycle implements TestLifecycle {
    private final Provider random;
    private final TestFieldInjector testFieldInjector;
    private final InteractionTestCase testCase;
    private final DataProviders dataProviders;
    private final Validator validator = new TestClassValidator();

    public InteractionTestLifecycle(InteractionTestCase testCase,
            MockSupport mocks,
            DataProviders dataProviders,
            Provider random) {
        this.testCase = testCase;
        this.random = random;
        this.dataProviders = dataProviders;
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
        ProvidesData baseProviders = new BoostDataProviders();
        baseProviders.register(dataProviders, random);
        if (hasMarker(ProvidesData.class)) ((ProvidesData) testCase).register(dataProviders, random);
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
