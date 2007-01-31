package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.atom.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.FieldSpecTestUtil;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import org.jmock.MockObjectTestCase;

// OK ClassDataAbstractionCoupling {
final class FieldInjectorTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final FieldSpecTestUtil fieldSpecTestUtil = new DefaultFieldSpecTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final FieldRetriever fieldRetriever = new DefaultFieldRetriever();
    private final ModifierTestUtil modifierTestUtil = new DefaultModifierTestUtil();
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
        Set fieldSpecSet = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Class fieldType = field.getType();
            String fieldName = field.getName();
            boolean isFinal = modifierTestUtil.isFinal(field);
            if (isFieldRandomizableAndNotFinal(isFinal, fieldType)) {
                addFieldToSet(fieldName, fieldType, fieldSpecSet);
            }
        }
        return (FieldSpec[]) fieldSpecSet.toArray(new FieldSpec[]{});
    }

    private void addFieldToSet(String fieldName, Class fieldType, Set fieldSpecSet) {
        FieldSpec fieldSpec = new DefaultFieldSpec(fieldName, fieldType);
        fieldSpecSet.add(fieldSpec);
    }

    private boolean isFieldRandomizableAndNotFinal(boolean isFinal, Class fieldType) {
        return !isFinal && isFieldRandomizable(fieldType);
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