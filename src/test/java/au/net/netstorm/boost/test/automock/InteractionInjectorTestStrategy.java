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
    private final Matcher mockMatcher = new MockableMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final UsesMocks testCase;

    public InteractionInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    // Hook in from jMock.  Needed for jMock to actually verify.
    public void verify() {
        mocker.verify();
    }

    public void init() {
        BoostField[] fields = getAllFields();
        validate(fields);
        injectMocks(fields);
        injectDummies(fields);
        invokeSubjectSetup();
    }

    private BoostField[] getAllFields() {
        return fieldBuilder.build(testCase);
    }

    private void validate(BoostField[] fields) {
        validator.validate(fields);
    }

    private void invokeSubjectSetup() {
        testCase.setupSubjects();
    }

    public void destroy() {
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setPublicInstance(testCase, "expect", mockExpectations);
    }

    private void injectDummies(BoostField[] fields) {
        BoostField[] dummyFields = selector.select(fields, dummyMatcher);
        Randomizer randomizer = new DefaultRandomizer();
        randomizer.randomize(dummyFields);
    }

    private void injectMocks(BoostField[] fields) {
        BoostField[] mockFields = selector.select(fields, mockMatcher);
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations expect = buildExpect(autoMocker);
        setExpectField(expect);
        autoMocker.mock(mockFields);
    }

    private MockExpectations buildExpect(AutoMocker autoMocker) {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }
}
// } DEBT DataAbstractionCoupling