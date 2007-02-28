package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.MockObjectTestCase;

// DEBT ClassDataAbstractionCoupling {
final class FieldInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldRetriever fieldRetriever = new AutoMockFieldRetriever();
    private final UsesMocks testCase;

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        BoostField[] eligibleFields = fieldRetriever.retrieve(testCase);
        // FIX 35593 Supported basic types are:
        // FIX 35593 Is a primitive?
        // FIX 35593 Is it a supported type?
        // FIX 35593 Is it an interface?
        // FIX 35593 Is it an array?  Does the array contain a basic type.

        // FIX BREADCRUMB 35593 Step 2: Stub primitives/strings.
        assignRandomValues(eligibleFields);
        // FIX BREADCRUMB 35593 Step 3: Mock mockables.
        assignMocks(eligibleFields);
        // FIX BREADCRUMB 35593 Step 4: Insert stubs/mocks into arrays.
        // FIX BREADCRUMB 35593 Step 5: Barf if any null fields left.

        // FIX 35593 Old stuff.  Remove when done.
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

    private void assignRandomValues(BoostField[] fields) {
        AutoRandomizer autoRandomizer = new PrimitiveAutoRandomizer(testCase);
        autoRandomizer.randomize(fields);
    }

    private void assignMocks(BoostField[] fields) {
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
// } DEBT ClassDataAbstractionCoupling - This class is basically a wirer / assembler.