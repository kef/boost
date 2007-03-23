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
    private final FieldBuilder fieldBuilder = new BoostFieldBuilder();
    private final FieldSelector selector = new DefaultFieldSelector();
    private final UsesMocks testCase;
    private final Matcher mockMatcher = new MockableMatcher();
    private final Matcher dummyMatcher = new DummyMatcher();

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        BoostField[] fields = getAllFields();
        validate(fields);
        injectMocks(fields);
        injectDummies(fields);
        testCase.setupSubjects();
    }

    private void validate(BoostField[] fields) {
        // FIX 1676 Delegate.
        for (int i = 0; i < fields.length; i++) {
            BoostField field = fields[i];
            if (field.isPrimitive()) throw new IllegalStateException("Rooster head.");
        }
        // FIX BREADCRUMB 1676 Boom on primitives.
        // FIX 1676 Break for primitive fields (maybe which aren't final).
        // FIX 1676 Break for fields which are not package private?
        // FIX 1676 Break if any fields are final (and not static?).
    }

    private BoostField[] getAllFields() {
        return fieldBuilder.build(testCase);
    }

    // Hook in from jMock.
    public void verify() {
        mocker.verify();
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