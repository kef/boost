package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.UsesSpecifics;

public final class InteractionTestLifecycle implements TestLifecycle {
    private final TestFieldInjector testFieldInjector;
    private final InteractionTestCase testCase;
    private final DataProviders specifics;

    public InteractionTestLifecycle(InteractionTestCase testCase, DataProviders specifics) {
        this.testCase = testCase;
        this.specifics = specifics;
        testFieldInjector = new DefaultTestFieldInjector(testCase, specifics);
    }

    public void pre() {
        doValidate();
        doRegisterSpecificProviders();
        doInjectAutoMocks();
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

    private void doRegisterSpecificProviders() {
        if (hasMarker(UsesSpecifics.class)) ((UsesSpecifics) testCase).registerSpecifics(specifics);
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

    private void doInjectAutoMocks() {
        if (hasMarker(UsesAutoMocks.class)) testFieldInjector.injectAutoMocks();
    }

    private boolean hasMarker(Class marker) {
        Class cls = testCase.getClass();
        return marker.isAssignableFrom(cls);
    }
}
