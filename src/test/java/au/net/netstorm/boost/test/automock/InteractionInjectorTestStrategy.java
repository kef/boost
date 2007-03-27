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
public final class InteractionInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final FieldValidator validator = new DefaultFieldValidator();
    private final Randomizer randomizer = new DefaultRandomizer();
    private final Matcher mockMatcher = new MockableMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final Matcher dummyArrayMatcher = new DummyArrayMatcher();
    private final UsesMocks testCase;
    private final AutoMocker autoMocker;

    public InteractionInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
        autoMocker = new DefaultAutoMocker(testCase, mockProvider);
    }

    // Hook in from jMock.  Needed for jMock to actually verify.
    public void verify() {
        mocker.verify();
    }

    public void destroy() {
    }

    public void init() {
        BoostField[] fields = getAllFields();
        validate(fields);
        injectMocks(fields);
        // FIX 1676 Inject mockArrays here. We need to have elements in an array that we can set expectations on.
        injectDummies(fields);
        injectDummyArrays(fields);
        subjectSetup();
        injectSubjects();
        setExpectField();
    }

    private BoostField[] getAllFields() {
        // FIX 1676 Don't get anything which starts with "subject".
        return fieldBuilder.build(testCase);
    }

    private void validate(BoostField[] fields) {
        validator.validate(fields);
    }

    private void injectMocks(BoostField[] fields) {
        BoostField[] mockFields = selector.select(fields, mockMatcher);
        autoMocker.mock(mockFields);
    }

    private void injectDummies(BoostField[] fields) {
        BoostField[] dummyFields = selector.select(fields, dummyMatcher);
        randomizer.randomize(dummyFields);
    }

    private void injectDummyArrays(BoostField[] fields) {
        BoostField[] arrays = selector.select(fields, dummyArrayMatcher);
        randomizer.randomize(arrays);
    }

    private void subjectSetup() {
        testCase.setupSubjects();
    }

    private void injectSubjects() {
        // FIX 1676 Inject subject fields using pebbliser.
    }

    private void setExpectField() {
        MockExpectations expect = buildExpect();
        fielder.setPublicInstance(testCase, "expect", expect);
    }

    private MockExpectations buildExpect() {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }
}
// } DEBT DataAbstractionCoupling