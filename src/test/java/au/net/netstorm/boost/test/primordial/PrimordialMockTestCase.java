package au.net.netstorm.boost.test.primordial;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public abstract class PrimordialMockTestCase extends MockObjectTestCase implements MockTestCase, MockTestSetUp, MockProvider {
    private final ImplicitMocker implicitMocker = new DefaultImplicitMocker(this, this);

    public void runBare() throws Throwable {
        setUpPrimordialMock();
        super.runBare();
    }

    public Mock mock(Class cls) {
// FIXME: SC525 Complete.
        return super.mock(cls);
    }

    // FIXME: SC525 Rename cls.
    public Mock mock(Class cls, String role) {
        // FIXME: SC525 complete.
        if (cls.isInterface()) {
            return super.mock(cls, role);
        }
        return super.mock(cls, role);
    }

    private void setUpPrimordialMock() {
        setUpMockReferences(this);
    }

    private void setUpMockReferences(MockTestSetUp mockSetup) {
        mockSetup.setUpMocks();
        mockSetup.setUpProxies();
        wireImplicitMocks();
        mockSetup.setUpFixtures();
    }

    private void wireImplicitMocks() {
        implicitMocker.wireMocks();
        // FIXME: SC525 Complete
    }

    public void setUpMocks() {
    }

    public void setUpProxies() {
    }

    public void setUpFixtures() {
    }
}
