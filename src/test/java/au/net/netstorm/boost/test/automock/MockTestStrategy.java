package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import org.jmock.MockObjectTestCase;

// OK ClassDataAbstractionCoupling {
final class MockTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final UsesMocks testCase;

    public MockTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        autoMocker.wireMocks();
        testCase.setupSubjects();
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setInstance(testCase, "expect", mockExpectations);
    }

    private MockExpectations buildMockExpectations(AutoMocker autoMocker) {
        MockExpectationHelper delegate = new DefaultMockExpectationHelper(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }

    public void destroy() {
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.