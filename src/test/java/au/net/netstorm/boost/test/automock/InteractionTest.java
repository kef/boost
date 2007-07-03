package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public final class InteractionTest implements TestLifecycle {
    private final AutoMockTest autoMockTest;
    private final BoooostCase testCase;

    public InteractionTest(BoooostCase testCase) {
        this.testCase = testCase;
        autoMockTest = new DefaultAutoMockTest(testCase);
    }

    public void pre() {
        doValidate();
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
