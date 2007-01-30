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
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final UsesMocks testCase;

    public FieldInjectorTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        Field[] fields = getFields(testCase);
        assignRandomsToPrimitives(fields);
        autoMockRemainingFields(fields);
        testCase.setupSubjects();
    }

    private void assignRandomsToPrimitives(Field[] fields) {
        FieldSpec[] primitiveFields = getPrimitiveFields(fields);
        Object[] instances = fieldSpecTestUtil.getInstances(primitiveFields);
        for (int i = 0; i < primitiveFields.length; i++) {
            FieldSpec primitiveField = primitiveFields[i];
            Object instanceValue = instances[i];
            fielder.setInstance(testCase, primitiveField.getName(), instanceValue);
        }
    }

    private FieldSpec[] getPrimitiveFields(Field[] fields) {
        Set fieldSpecSet = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Class fieldType = field.getType();
            if (primitiveBoxer.isPrimitive(fieldType)) {
                FieldSpec fieldSpec = new DefaultFieldSpec(field.getName(), fieldType);
                fieldSpecSet.add(fieldSpec);
            }
        }
        return (FieldSpec[]) fieldSpecSet.toArray(new FieldSpec[]{});
    }

    private void autoMockRemainingFields(Field[] fields) {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        autoMocker.wireMocks(fields);
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

    // FIX 1671 Move this stuff to a different class.
    private Field[] getFields(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return siftOutSyntheticFields(fields);
    }

    // FIX 1665 Do we really need this.
    private Field[] siftOutSyntheticFields(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (!field.getName().contains("$")) {
                result.add(field);
            }
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.