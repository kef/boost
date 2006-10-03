package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

// SUGGEST So we don't need test subclasses.  We just have the one and it implements Marker interface to key the type of test.
// SUGGEST Do not extend MockObjectTestCase.
// FIX SC525 Lock down final on methods.
public abstract class PrimordialMockTestCase extends MockObjectTestCase implements MockTestCase, MockTestSetUp, MockProvider {
    private final ImplicitMocker implicitMocker = new DefaultImplicitMocker(this, this);

    public final void runBare() throws Throwable {
        setUpPrimordialMock();
        super.runBare();
    }

    public Mock mock(Class cls) {
// SUGGEST Complete.
        return super.mock(cls);
    }

    // SUGGEST Rename cls.
    public Mock mock(Class cls, String role) {
        // SUGGEST complete.
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
        // SUGGEST Complete
    }

    public void setUpMocks() {
    }

    public void setUpProxies() {
    }

    public void setUpFixtures() {
    }
}
