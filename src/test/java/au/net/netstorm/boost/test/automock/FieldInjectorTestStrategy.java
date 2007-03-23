package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.TestStrategy;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.DefaultFieldSelector;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.field.Matcher;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.MockObjectTestCase;

// DEBT DataAbstractionCoupling {
public final class FieldInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldRetriever fieldRetriever = new AutoMockFieldRetriever();
    private final FieldBuilder builder = new BoostFieldBuilder();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final UsesMocks testCase;
    private Matcher mockMatcher = new MockableMatcher();

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        // FIX 1676 Break for primitive fields (maybe which aren't final).
        // FIX 1676 Break for fields which are not package private?
        // FIX 1676 Break if any fields are final (and not static?).
        BoostField[] fields = builder.build(testCase);
        BoostField[] mockFields = selector.select(fields, mockMatcher);
        // FIX 1676 The whole list of injectable fields is not interesting.
        // Change this to return only MOCKABLE fields. This should use the fieldFinder pattern.
        BoostField[] eligibleFields = fieldRetriever.retrieve(testCase);
        injectMocks(mockFields);
        injectDummies(eligibleFields);
        testCase.setupSubjects();
    }

    public void verify() {
        mocker.verify();
    }

    public void destroy() {
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setPublicInstance(testCase, "expect", mockExpectations);
    }

    private void injectDummies(BoostField[] fields) {
        Randomizer randomizer = new DefaultRandomizer(testCase);
        randomizer.randomize(fields);
    }

    private void injectMocks(BoostField[] fields) {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations expect = buildExpect(autoMocker);
        setExpectField(expect);
        autoMocker.mock(fields);
    }

    private MockExpectations buildExpect(AutoMocker autoMocker) {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }
}
// } DEBT DataAbstractionCoupling