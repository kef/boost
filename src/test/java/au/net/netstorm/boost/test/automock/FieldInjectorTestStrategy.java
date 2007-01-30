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

    private void assignRandomValuesToEligibleFields(Field[] fields) {
        FieldSpec[] eligibleFields = getFieldsToRandomize(fields);
        Object[] randomInstances = fieldSpecTestUtil.getInstances(eligibleFields);
        for (int i = 0; i < eligibleFields.length; i++) {
            FieldSpec primitiveField = eligibleFields[i];
            Object randomValue = randomInstances[i];
            fielder.setInstance(testCase, primitiveField.getName(), randomValue);
        }
    }

    private FieldSpec[] getFieldsToRandomize(Field[] fields) {
        Set fieldSpecSet = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Class fieldType = field.getType();
            if (isFieldRandomizableAndNotFixed(fieldType, field.getName())) {
                FieldSpec fieldSpec = new DefaultFieldSpec(field.getName(), fieldType);
                fieldSpecSet.add(fieldSpec);
            }
        }
        return (FieldSpec[]) fieldSpecSet.toArray(new FieldSpec[]{});
    }

    private boolean isFieldRandomizableAndNotFixed(Class fieldType, String fieldName) {
        return primitiveBoxer.isPrimitive(fieldType) && !fieldName.startsWith("fixed");
    }

    private void autoMockRemainingFields(Field[] fields) {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        autoMocker.wireMocks(fields);
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.