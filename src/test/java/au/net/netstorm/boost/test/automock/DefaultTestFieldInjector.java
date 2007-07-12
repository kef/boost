package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.field.BoostFieldBuilder;
import au.net.netstorm.boost.test.field.DefaultFieldSelector;
import au.net.netstorm.boost.test.field.FieldBuilder;
import au.net.netstorm.boost.test.field.FieldSelector;
import au.net.netstorm.boost.test.inject.DefaultSubjectInjector;
import au.net.netstorm.boost.test.inject.SubjectInjector;
import au.net.netstorm.boost.test.matcher.ArrayMatcher;
import au.net.netstorm.boost.test.matcher.ConcreteMatcher;
import au.net.netstorm.boost.test.matcher.DummyMatcher;
import au.net.netstorm.boost.test.matcher.InterfaceMatcher;
import au.net.netstorm.boost.test.matcher.Matcher;
import au.net.netstorm.boost.test.random.BoostFieldRandomizer;
import au.net.netstorm.boost.test.random.DefaultSpecificProviderAssembler;
import au.net.netstorm.boost.test.random.Randomizer;
import au.net.netstorm.boost.test.random.SpecificProviderAssembler;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.specific.Specifics;
import org.jmock.MockObjectTestCase;

// DEBT DataAbstractionCoupling {
public final class DefaultTestFieldInjector implements TestFieldInjector {
    private final SpecificProviderAssembler providerAssembler = new DefaultSpecificProviderAssembler();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final Matcher interfaceMatcher = new InterfaceMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();
    private final Matcher arrayMatcher = new ArrayMatcher();
    private final Matcher concreteMatcher = new ConcreteMatcher();
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldValidator validator = new DefaultFieldValidator();
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final Randomizer randomizer;
    private final AutoMocker autoMocker;
    private final BoostField[] fields;
    private final LifecycleTestCase testCase;

    public DefaultTestFieldInjector(LifecycleTestCase testCase, Specifics specifics) {
        this.testCase = testCase;
        Provider randomProvider = providerAssembler.everything(specifics);
        randomizer = new BoostFieldRandomizer(randomProvider);
        autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        fields = getAllFields();
    }

    public void validate() {
        validator.validate(fields);
    }

    public void injectAutoMocks() {
        injectDummies(fields);
        injectInterfaces(fields);
        injectArrays(fields);
        injectConcretes(fields);
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

    private void injectDummies(BoostField[] fields) {
        BoostField[] dummyFields = selector.select(fields, dummyMatcher);
        randomizer.randomize(dummyFields);
    }

    private void injectInterfaces(BoostField[] fields) {
        BoostField[] mockFields = selector.select(fields, interfaceMatcher);
        autoMocker.mock(mockFields);
    }

    private void injectArrays(BoostField[] fields) {
        BoostField[] arrays = selector.select(fields, arrayMatcher);
        randomizer.randomize(arrays);
    }

    private void injectConcretes(BoostField[] fields) {
        BoostField[] concreteFields = selector.select(fields, concreteMatcher);
        randomizer.randomize(concreteFields);
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