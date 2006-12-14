package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.TestCase;

public class DefaultFieldValueSpecAtomicTest extends TestCase {
    private static final String NAME_1 = "x";
    private static final String NAME_2 = "y";
    private static final Object VALUE_1 = new Object();
    private static final Object VALUE_2 = new Object();
    private static final FieldValueSpec FIELD_VALUE_SPEC_1 = new DefaultFieldValueSpec("field1", new Integer(77));
    private static final FieldValueSpec FIELD_VALUE_SPEC_2 = new DefaultFieldValueSpec("field7", "Is absolute zero cold enough?");
    private static final FieldValueSpec FIELD_VALUE_SPEC_NULL = new DefaultFieldValueSpec(NAME_1, null);
    private static final Object VALUE_CAN_BE_NULL = null;

    public void testMarker() {
        assertTrue(Immutable.class.isAssignableFrom(DefaultFieldValueSpec.class));
    }

    public void testNullNameIllegalInConstructor() {
        checkNullNameIllegalInConstructor(null, VALUE_1);
    }

    public void testCreate() {
        checkCreate(NAME_1, VALUE_CAN_BE_NULL);
        checkCreate(NAME_1, VALUE_1);
        checkCreate(NAME_2, VALUE_2);
    }

    public void testHashCode() {
        checkHashCode(FIELD_VALUE_SPEC_1);
        checkHashCode(FIELD_VALUE_SPEC_2);
    }

    public void testEquals() {
        checkNames();
        checkSimpleValues();
    }

    public void testToString() {
        checkToString("DefaultFieldValueSpec[name=field1,value=77]", FIELD_VALUE_SPEC_1);
        checkToString("DefaultFieldValueSpec[name=field7,value=Is absolute zero cold enough?]", FIELD_VALUE_SPEC_2);
    }

    private void checkNames() {
        checkEquals(FIELD_VALUE_SPEC_1, FIELD_VALUE_SPEC_1);
        checkEquals(FIELD_VALUE_SPEC_1, FIELD_VALUE_SPEC_1);
        checkNotEquals(FIELD_VALUE_SPEC_1, FIELD_VALUE_SPEC_2);
        checkNotEquals(FIELD_VALUE_SPEC_2, FIELD_VALUE_SPEC_1);
    }

    private void checkSimpleValues() {
        checkEquals(FIELD_VALUE_SPEC_1, FIELD_VALUE_SPEC_1);
        checkEquals(FIELD_VALUE_SPEC_NULL, FIELD_VALUE_SPEC_NULL);
        checkNotEquals(FIELD_VALUE_SPEC_1, FIELD_VALUE_SPEC_NULL);
        checkNotEquals(FIELD_VALUE_SPEC_NULL, FIELD_VALUE_SPEC_1);
    }

    private void checkHashCode(FieldValueSpec spec) {
        assertEquals(42, spec.hashCode());
    }

    private void checkToString(String expected, FieldValueSpec spec) {
        assertEquals(expected, spec.toString());
    }

    private void checkCreate(String name, Object value) {
        FieldValueSpec fieldValue = new DefaultFieldValueSpec(name, value);
        assertEquals(name, fieldValue.getName());
        assertEquals(value, fieldValue.getValue());
    }

    private void checkNullNameIllegalInConstructor(String name, Object value) {
        try {
            new DefaultFieldValueSpec(name, value);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals(name + " parameter should not be null", expected.getMessage());
        }
    }

    private void checkEquals(FieldValueSpec fieldValue1, FieldValueSpec fieldValue2) {
        assertEquals(fieldValue1, fieldValue2);
    }

    private void checkNotEquals(FieldValueSpec fieldValue1, FieldValueSpec fieldValue2) {
        assertTrue(!fieldValue1.equals(fieldValue2));
    }
}
