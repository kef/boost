package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.MockObjectTestCase;

// OK ClassDataAbstractionCoupling {
final class FieldInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldRetriever fieldRetriever = new DefaultFieldRetriever();
    private final UsesMocks testCase;

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        Field[] fields = fieldRetriever.retrieve(testCase);
        // FIX BREADCRUMB 35593 Step 0: Detect non-null and non-final fields.
        // FIX BREADCRUMB 35593 Step 1: Find arrays and barf if duplicate component types found.
        // FIX BREADCRUMB 35593 Step 2: Stub primitives/strings (collect for arrays).
        // FIX BREADCRUMB 35593 Step 3: Mock mockables (collect for arrays).
        // FIX BREADCRUMB 35593 Step 4: Insert stubs/mocks into arrays.
        // FIX BREADCRUMB 35593 Step 5: Barf if any null fields left.

        // FIX 35593 Old stuff.  Remove when done.
        assignRandomValuesToEligibleFields(fields);
        autoMockRemainingFields(fields);
        testCase.setupSubjects();
    }

    public void verify() {
        mocker.verify();
    }

    public void destroy() {
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setInstance(testCase, "expect", mockExpectations);
    }

    private void assignRandomValuesToEligibleFields(Field[] fields) {
        AutoRandomizer autoRandomizer = new PrimitiveAutoRandomizer(testCase);
        autoRandomizer.randomize(fields);
    }

    private void autoMockRemainingFields(Field[] fields) {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        autoMocker.wireMocks(fields);
    }

    private MockExpectations buildMockExpectations(AutoMocker autoMocker) {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.