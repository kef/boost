package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.spider.core.Destroyable;
import au.net.netstorm.boost.spider.core.Initialisable;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.cases.JUnitLifecycle;
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
public final class InteractionTest implements JUnitLifecycle {
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
    private final SubjectInjector subjectInjector = new DefaultSubjectInjector();
    private final BoooostCase testCase;
    private final AutoMocker autoMocker;
    private final BoostField[] fields;

    public InteractionTest(BoooostCase testCase) {
        this.testCase = testCase;
        autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        fields = getAllFields();
    }

    // Hook in from jMock.  Needed for jMock to actually verify.
    public void post() {
        mocker.verify();
    }

    public void pre() {
        doValidate();
        doInjectAutoMocks();
        doInitialise();
        doSetupSubject();
        doInjectSubject();
        doSetExpectField();
    }

    private void injectAutoMocks(BoostField[] fields) {
        injectMocks(fields);
        // FIX 1676 Inject mockArrays here. We need to have elements in an array that we can set expectations on.
        injectDummies(fields);
        injectDummyArrays(fields);
    }

    public void cleanup() {
        doDestroy();
    }

    private BoostField[] getAllFields() {
        // FIX 1676 Don't get anything which starts with "subject".
        return fieldBuilder.build(testCase);
    }

    private void doValidate() {
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

    private void injectSubject() {
        subjectInjector.inject(testCase);
    }

    private void setExpectField() {
        MockExpectations expect = buildExpect();
        fielder.setPublicInstance(testCase, "expect", expect);
    }

    private MockExpectations buildExpect() {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }

    private boolean hasMarker(Class marker) {
        Class cls = testCase.getClass();
        return marker.isAssignableFrom(cls);
    }

    // Below are our marker calls.

    private void doInjectSubject() {
        if (hasMarker(InjectSubject.class)) injectSubject();
    }

    private void doSetExpectField() {
        if (hasMarker(UsesExpectations.class)) setExpectField();
    }

    private void doDestroy() {
        if (hasMarker(Destroyable.class)) ((Destroyable) testCase).destroy();
    }

    private void doInitialise() {
        if (hasMarker(Initialisable.class)) ((Initialisable) testCase).initialise();
    }

    private void doSetupSubject() {
        if (hasMarker(HasSubjects.class)) ((HasSubjects) testCase).setupSubjects();
    }

    private void doInjectAutoMocks() {
        if (hasMarker(UsesAutoMocks.class)) injectAutoMocks(fields);
    }
}
// } DEBT DataAbstractionCoupling