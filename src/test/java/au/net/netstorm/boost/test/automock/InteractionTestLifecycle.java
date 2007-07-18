package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.specific.BoostDataProviders;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.ProvidesData;

public final class InteractionTestLifecycle implements TestLifecycle {
    private final TestFieldInjector testFieldInjector;
    private final InteractionTestCase testCase;
    private final DataProviders data;
    private final Provider random;

    public InteractionTestLifecycle(InteractionTestCase testCase, DataProviders data, Provider random) {
        this.testCase = testCase;
        this.data = data;
        this.random = random;
        testFieldInjector = new DefaultTestFieldInjector(testCase, data);
    }

    public void pre() {
        doValidate();
        doRegisterDataProviders();
        doInjectLazyFields();
        doInitialise();
        doSetupSubject();
        doInjectSubject();
        doSetExpectField();
    }

    public void post() {
        // Hook in from jMock.  Needed for jMock to actually verify.
        testFieldInjector.verify();
    }

    public void cleanup() {
        doDestroy();
    }

    private void doValidate() {
        testFieldInjector.validate();
    }

    private void doRegisterDataProviders() {
        ProvidesData baseProviders = new BoostDataProviders(random);
        baseProviders.register(data);
        if (hasMarker(ProvidesData.class)) ((ProvidesData) testCase).register(data);
    }

    private void doInjectSubject() {
        if (hasMarker(InjectableSubject.class)) testFieldInjector.injectSubject();
    }

    private void doSetExpectField() {
        if (hasMarker(UsesExpectations.class)) testFieldInjector.setExpectField();
    }

    private void doDestroy() {
        if (hasMarker(Destroyable.class)) ((Destroyable) testCase).destroy();
    }

    private void doInitialise() {
        if (hasMarker(Initialisable.class)) ((Initialisable) testCase).initialise();
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
