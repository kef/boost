package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.DefaultFieldSelector;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
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
    private final FieldSelector selector = new DefaultFieldSelector();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldValidator validator = new DefaultFieldValidator();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Matcher randomMatcher = new RandomMatcher();
    private final Matcher mockMatcher = new MockMatcher();
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
        injectMocks();
        injectRandoms();
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

    private void injectRandoms() {
        BoostField[] injectables = selector.select(fields, randomMatcher);
        randomizer.randomize(injectables);
    }

    private void injectMocks() {
        BoostField[] mockables = selector.select(fields, mockMatcher);
        for (int i = 0; i < mockables.length; i++) {
            injectMock(mockables[i], testCase);
        }
    }

    private void injectMock(BoostField field, LifecycleTestCase testCase) {
        Object mock = autoMocker.mock(field);
        String name = field.getName();
        fielder.setInstance(testCase, name, mock);
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