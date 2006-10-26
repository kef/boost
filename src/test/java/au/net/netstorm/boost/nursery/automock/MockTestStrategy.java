package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;

// FIX SC525 Complete this.
public final class MockTestStrategy implements TestStrategy {
    private final Object testCase;
    private final FieldTestUtil testUtil = new DefaultFieldTestUtil();

    public MockTestStrategy(Object testCase) {
        this.testCase = testCase;
    }

    public void init() {
        MockExpectations mockExpectations = new DefaultMockExpectations();
        testUtil.setInstance(testCase,"expect", mockExpectations);
        // FIX SC525 Set the "expec÷t" reference in the test object.
        // FIX SC525 Wire in all mocks (via automocking).
        // FIX SC525 Complete.
    }

    public void destroy() {
    }
}