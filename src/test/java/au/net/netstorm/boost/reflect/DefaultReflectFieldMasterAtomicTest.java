package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;

// DEBT ClassDataAbstractionCoupling {
public class DefaultReflectFieldMasterAtomicTest extends BoooostCase {
    private static final FieldValueSpec[] NO_FIELDS = new FieldValueSpec[0];
    private static final String FIELD_VALUE_1 = "REFACTORING IS THE MOST IMPORTANT THING YOU COULD BE DOING";
    private static final String FIELD_VALUE_2 = "TEAR DOWN THE BARRIERS TO ADHOC PAIRING";
    private static final Integer WRAPPED_INTEGER_1 = new Integer(1);
    private static final Object ZERO_INSTANCE_FIELDS_OBJECT = new TestSubjects.TestZeroInstanceFieldsObject();
    private static final Object ZERO_INSTANCE_ONE_STATIC_FIELDS_OBJECT = new TestSubjects.TestZeroInstanceOneStaticFieldsObject();
    private static final Object ONE_INSTANCE_FIELD_OBJECT_1 = new TestSubjects.TestOneInstanceFieldObject(FIELD_VALUE_1);
    private static final Object ONE_INSTANCE_FIELD_OBJECT_2 = new TestSubjects.TestOneInstanceFieldObject(FIELD_VALUE_2);
    private static final Object ONE_PRIMITIVE_INSTANCE_FIELD_OBJECT = new TestSubjects.TestOnePrimitiveInstanceFieldObject(1);
    private static final FieldValueSpec[] EXPECTED_FIELDS_1 = createFieldSpec(FIELD_VALUE_1);
    private static final FieldValueSpec[] EXPECTED_FIELDS_2 = createFieldSpec(FIELD_VALUE_2);
    private final ReflectFieldMaster master = new DefaultReflectFieldMaster();

    public void testFields() {
        checkFields(NO_FIELDS, ZERO_INSTANCE_FIELDS_OBJECT);
        checkFields(NO_FIELDS, ZERO_INSTANCE_ONE_STATIC_FIELDS_OBJECT);
        checkFields(EXPECTED_FIELDS_1, ONE_INSTANCE_FIELD_OBJECT_1);
        checkFields(EXPECTED_FIELDS_2, ONE_INSTANCE_FIELD_OBJECT_2);
        checkFields(createFieldSpec(WRAPPED_INTEGER_1), ONE_PRIMITIVE_INSTANCE_FIELD_OBJECT);
    }

    private void checkFields(FieldValueSpec[] expectedFields, Object o) {
        FieldValueSpec[] actualFields = master.getInstanceFields(o);
        assertEquals(expectedFields, actualFields);
    }

    private static FieldValueSpec[] createFieldSpec(Object value) {
        FieldValueSpec field = new DefaultFieldValueSpec("value", value);
        return new FieldValueSpec[]{field};
    }
}
// } DEBT ClassDataAbstractionCoupling
