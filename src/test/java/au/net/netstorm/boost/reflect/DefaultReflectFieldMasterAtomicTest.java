package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public class DefaultReflectFieldMasterAtomicTest extends PrimordialTestCase {
    private static final FieldValueSpec[] NO_FIELDS = new FieldValueSpec[0];
    private static final String FIELD_VALUE_1 = "REFACTORING IS THE MOST IMPORTANT THING YOU COULD BE DOING";
    private static final String FIELD_VALUE_2 = "TEAR DOWN THE BARRIERS TO ADHOC PAIRING";
    private static final Integer WRAPPED_INTEGER_1 = new Integer(1);
    private static final Object ZERO_INSTANCE_FIELDS_OBJECT = new TestSubjects.TestZeroInstanceFieldsObject();
    private static final Object ZERO_INSTANCE_ONE_STATIC_FIELDS_OBJECT = new TestSubjects.TestZeroInstanceOneStaticFieldsObject();
    private static final Object ONE_INSTANCE_FIELD_OBJECT_1 = new TestSubjects.TestOneInstanceFieldObject(FIELD_VALUE_1);
    private static final Object ONE_INSTANCE_FIELD_OBJECT_2 = new TestSubjects.TestOneInstanceFieldObject(FIELD_VALUE_2);
    private static final Object ONE_PRIMITIVE_INSTANCE_FIELD_OBJECT = new TestSubjects.TestOnePrimitiveInstanceFieldObject(1);
    private final ReflectFieldMaster master = new DefaultReflectFieldMaster();

    // FIXME: SC506 Constants for train wreck.
    public void testFields() {
        checkFields(NO_FIELDS, ZERO_INSTANCE_FIELDS_OBJECT);
        checkFields(NO_FIELDS, ZERO_INSTANCE_ONE_STATIC_FIELDS_OBJECT);
        checkFields(createFieldSpec(FIELD_VALUE_1), ONE_INSTANCE_FIELD_OBJECT_1);
        checkFields(createFieldSpec(FIELD_VALUE_2), ONE_INSTANCE_FIELD_OBJECT_2);
        checkFields(createFieldSpec(WRAPPED_INTEGER_1), ONE_PRIMITIVE_INSTANCE_FIELD_OBJECT);
    }

    private void checkFields(FieldValueSpec[] expected, Object o) {
        assertEquals(expected, master.getInstanceFields(o));
    }

    private FieldValueSpec[] createFieldSpec(Object value) {
        return new FieldValueSpec[]{new DefaultFieldValueSpec("value", value)};
    }
}
