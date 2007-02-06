package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.atom.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.FieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import org.jmock.MockObjectTestCase;

// FIX 1665 Tidy this up!!!!!!!!!!!!!!!!!!!!!!!!!
// FIX 1665 Remove dupe.
// FIX 1665 Convert all 1671 fixes to 1665.

// OK ClassDataAbstractionCoupling {
final class FieldInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldSpecTestUtil fieldSpecTestUtil = new DefaultFieldSpecTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final FieldRetriever fieldRetriever = new DefaultFieldRetriever();
    private final UsesMocks testCase;

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        Field[] fields = fieldRetriever.retrieve(testCase);
        assignRandomValuesToEligibleFields(fields);
        autoMockRemainingFields(fields);
        testCase.setupSubjects();
    }

    public void verify() {
        mocker.verify();
    }

    public void destroy() {
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setInstance(testCase, "expect", mockExpectations);
    }

    private MockExpectations buildMockExpectations(AutoMocker autoMocker) {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }

    // FIX BREADCRUMB 1665 -100000000000 Over here.
    // FIX 1665 Create a PrimitiveRandomizer which behaves and looks like automocker.  Delegate to it.
    // FIX 1671 Seperate Class called AutoRandomizer like AutoMocker.
    private void assignRandomValuesToEligibleFields(Field[] fields) {
        FieldSpec[] eligibleFields = getFieldsToRandomize(fields);
        Object[] randomInstances = fieldSpecTestUtil.getInstances(eligibleFields);
        for (int i = 0; i < eligibleFields.length; i++) {
            FieldSpec primitiveField = eligibleFields[i];
            Object randomValue = randomInstances[i];
            fielder.setInstance(testCase, primitiveField.getName(), randomValue);
        }
    }

    // FIX 32416 Too big.
    private FieldSpec[] getFieldsToRandomize(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            addIfRandomizable(fields[i], result);
        }
        return (FieldSpec[]) result.toArray(new FieldSpec[]{});
    }

    private void addIfRandomizable(Field field, Set result) {
        Class fieldType = field.getType();
        String fieldName = field.getName();
        if (!isFieldRandomizable(fieldType))
            return;
        if (isFieldSet(field))
            return;
        addFieldToSet(fieldName, fieldType, result);
    }

    private boolean isFieldSet(Field field) {
        Object ref = fielder.getInstance(testCase, field);
        return ref != null;
    }

    private void addFieldToSet(String fieldName, Class fieldType, Set fieldSpecSet) {
        FieldSpec fieldSpec = new DefaultFieldSpec(fieldName, fieldType);
        fieldSpecSet.add(fieldSpec);
    }

    private boolean isFieldRandomizable(Class fieldType) {
        return primitiveBoxer.isPrimitive(fieldType) || fieldType.equals(String.class);
    }

    private void autoMockRemainingFields(Field[] fields) {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        autoMocker.wireMocks(fields);
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.