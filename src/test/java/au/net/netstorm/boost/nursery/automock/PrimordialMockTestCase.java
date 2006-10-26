package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.util.type.DefaultInterface;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

// SUGGEST So we don't need test subclasses.  We just have the one and it implements Marker interface to key the type of test.
// SUGGEST Do not extend MockObjectTestCase.
// FIX SC525 Lock down final on methods.
// FIX SC525 The primordial test case could populate expected fields providing container like functionality.
// FIX SC525 For example subclasses wanting to mock would be provided with a mocker reference,
// FIX SC525 rather than making upcalls.  Fail if the field is not declared(?)
// FIX SC525 Move this sideways and delegate from PrimordialTestCase based on interface markings.

public final class PrimordialMockTestCase  implements UsesMocks, MockTestSetUp, MockProvider {
    private final MockObjectTestCase mocker = new MockObjectTestCase() {
    };
    private final AutoMocker autoMocker = new DefaultAutoMocker(this, this);

    public Mock mock(Class cls) {
        checkIsInterface(cls);
        Mock mock = mocker.mock(cls);
        mocker.registerToVerify(mock);
        return mock;
    }

    // FIX SC525 Complete.
    public Mock mock(Class mockType, String role) {
        throw new UnsupportedOperationException();
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
        autoMocker.wireMocks();
        // SUGGEST Complete
    }

    public void setUpMocks() {
    }

    public void setUpProxies() {
    }

    public void setUpFixtures() {
    }

    private void checkIsInterface(Class cls) {
        new DefaultInterface(cls);
    }

    public void wireFixtures() {
    }
}
