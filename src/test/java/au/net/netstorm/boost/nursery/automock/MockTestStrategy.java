package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;

// FIX SC525 Complete this.
public final class MockTestStrategy implements TestStrategy {
    private final UsesMocks testCase;
    private final FieldTestUtil testUtil = new DefaultFieldTestUtil();

    public MockTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase);
        MockExpectations mockExpectations = new DefaultMockExpectations(autoMocker);
        testUtil.setInstance(testCase, "expect", mockExpectations);
        testCase.setupSubjects();
        autoMocker.wireMocks();
        // FIX SC525 Set the "expect" reference in the test object.
        // FIX SC525 Wire in all mocks (via automocking).
        // FIX SC525 Complete.
    }

    public void destroy() {
    }
}