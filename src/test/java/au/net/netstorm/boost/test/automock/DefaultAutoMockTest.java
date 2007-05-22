package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.DefaultFieldSelector;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.field.Matcher;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.MockObjectTestCase;

// DEBT DataAbstractionCoupling {
public final class DefaultAutoMockTest implements AutoMockTest {
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final Randomizer randomizer = new DefaultRandomizer();
    private final Matcher mockMatcher = new MockableMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final Matcher dummyArrayMatcher = new DummyArrayMatcher();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldValidator validator = new DefaultFieldValidator();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final AutoMocker autoMocker;
    private final BoostField[] fields;
    private final BoooostCase testCase;

    public DefaultAutoMockTest(BoooostCase testCase) {
        this.testCase = testCase;
        autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        fields = getAllFields();
    }

    public void validate() {
        validator.validate(fields);
    }

    public void injectAutoMocks() {
        injectMocks(fields);
        injectDummies(fields);
        injectDummyArrays(fields);
    }

    public void injectSubject() {
        subjectInjector.inject(testCase);
    }

    public void setExpectField() {
        MockExpectations expect = buildExpect();
        fielder.setPublicInstance(testCase, "expect", expect);
    }

    public void verify() {
        mocker.verify();
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

    private BoostField[] getAllFields() {
        return fieldBuilder.build(testCase);
    }

    private MockExpectations buildExpect() {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }
}
// } DEBT DataAbstractionCoupling