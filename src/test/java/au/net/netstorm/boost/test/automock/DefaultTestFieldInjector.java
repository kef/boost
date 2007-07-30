package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.field.TestFieldSelector;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
import au.net.netstorm.boost.test.matcher.DummyMatcher;
import au.net.netstorm.boost.test.matcher.InjectableMatcher;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.matcher.MockMatcher;
import au.net.netstorm.boost.test.matcher.RandomMatcher;
import au.net.netstorm.boost.test.random.BoostFieldRandomizer;
import au.net.netstorm.boost.test.random.DefaultRandomProviderAssembler;
import au.net.netstorm.boost.test.random.RandomProviderAssembler;
import au.net.netstorm.boost.test.random.Randomizer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.specific.DataProviders;

// DEBT DataAbstractionCoupling {
public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final RandomProviderAssembler providerAssembler = new DefaultRandomProviderAssembler();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final FieldSelector selector = new TestFieldSelector();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldValidator validator = new DefaultFieldValidator();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Matcher injectablesMatcher = new InjectableMatcher();
    private final Matcher randomMatcher = new RandomMatcher();
    private final Matcher mockMatcher = new MockMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final Randomizer randomizer;
    private final BoostField[] fields;
    private final LifecycleTestCase testCase;
    private AutoMocker autoMocker;

    public DefaultTestFieldInjector(LifecycleTestCase testCase, DataProviders dataProviders) {
        this.testCase = testCase;
        autoMocker = new DefaultAutoMocker(mockProvider);
        Provider randomProvider = providerAssembler.everything(dataProviders, autoMocker);
        randomizer = new BoostFieldRandomizer(randomProvider);
        fields = getAllFields();
    }

    public void validate() {
        validator.validate(fields);
    }

    public void inject() {
        BoostField[] injectables = selector.select(fields, injectablesMatcher);
        injectMocks(injectables);
        injectDummies(injectables);
        injectRandoms(injectables);
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

    private void injectRandoms(BoostField[] injectables) {
        BoostField[] randoms = selector.select(injectables, randomMatcher);
        randomizer.randomize(randoms);
    }

    private void injectMocks(BoostField[] injectables) {
        BoostField[] mockables = selector.select(injectables, mockMatcher);
        for (int i = 0; i < mockables.length; i++) {
            Object mock = autoMocker.mock(mockables[i]);
            setTestField(mockables[i], mock);
        }
    }

    private void injectDummies(BoostField[] injectables) {
        BoostField[] dummies = selector.select(injectables, dummyMatcher);
        for (int i = 0; i < dummies.length; i++) {
            Object dummy = autoMocker.dummy(dummies[i]);
            setTestField(dummies[i], dummy);
        }
    }

    private void setTestField(BoostField field, Object value) {
        String name = field.getName();
        fielder.setInstance(testCase, name, value);
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