package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import org.jmock.MockObjectTestCase;

// FIX SC525 Complete this.
public final class MockTestStrategy implements TestStrategy {
    private final FieldTestUtil testUtil = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final UsesMocks testCase;

    public MockTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = new DefaultMockExpectations(autoMocker, mocker);
        testUtil.setInstance(testCase, "expect", mockExpectations);
        autoMocker.wireMocks();
        testCase.setupSubjects();
        // FIX SC525 Set the "expect" reference in the test object.
        // FIX SC525 Wire in all mocks (via automocking).
        // FIX SC525 Complete.
    }

    public void destroy() {
    }
}