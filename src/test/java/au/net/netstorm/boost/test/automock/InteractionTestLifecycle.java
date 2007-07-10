package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.specific.UsesSpecifics;

public final class InteractionTestLifecycle implements TestLifecycle {
    private final AutoMockTest autoMockTest;
    private final InteractionTestCase testCase;

    public InteractionTestLifecycle(InteractionTestCase testCase) {
        this.testCase = testCase;
        // FIX 2076 Rename.  No longer does just mocks.
        autoMockTest = new DefaultAutoMockTest(testCase, testCase.getSpecifics());
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
        autoMockTest.verify();
    }

    public void cleanup() {
        doDestroy();
    }

    private void doValidate() {
        autoMockTest.validate();
    }

    private void doRegisterSpecificProviders() {
        if (hasMarker(UsesSpecifics.class)) ((UsesSpecifics) testCase).registerSpecifics(testCase.getSpecifics());
    }

    private void doInjectSubject() {
        if (hasMarker(InjectableSubject.class)) autoMockTest.injectSubject();
    }

    private void doSetExpectField() {
        if (hasMarker(UsesExpectations.class)) autoMockTest.setExpectField();
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
        if (hasMarker(UsesAutoMocks.class)) autoMockTest.injectAutoMocks();
    }

    private boolean hasMarker(Class marker) {
        Class cls = testCase.getClass();
        return marker.isAssignableFrom(cls);
    }
}
