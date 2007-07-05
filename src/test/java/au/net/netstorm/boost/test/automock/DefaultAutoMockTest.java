package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.DefaultFieldSelector;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
import au.net.netstorm.boost.test.matcher.DummyArrayMatcher;
import au.net.netstorm.boost.test.matcher.DummyMatcher;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.matcher.MockableMatcher;
import au.net.netstorm.boost.test.random.BoostFieldRandomizer;
import au.net.netstorm.boost.test.random.EverythingRandomProvider;
import au.net.netstorm.boost.test.random.RandomProvider;
import au.net.netstorm.boost.test.random.Randomizer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import org.jmock.MockObjectTestCase;

// DEBT DataAbstractionCoupling {
public final class DefaultAutoMockTest implements AutoMockTest {
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final Matcher mockMatcher = new MockableMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final Matcher dummyArrayMatcher = new DummyArrayMatcher();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldValidator validator = new DefaultFieldValidator();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Randomizer randomizer;
    private final AutoMocker autoMocker;
    private final BoostField[] fields;
    private final InteractionTestCase testCase;

    public DefaultAutoMockTest(InteractionTestCase testCase, SpecificProviderRegistry specifics) {
        this.testCase = testCase;
        RandomProvider randomProvider = new EverythingRandomProvider(specifics);
        randomizer = new BoostFieldRandomizer(randomProvider);
        autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        fields = getAllFields();
    }

    public void validate() {
        validator.validate(fields);
    }

    public void injectAutoMocks() {
        injectDummies(fields);
        injectMocks(fields);
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