package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.TestCase;

// FIXME: SC509 Currently primitive types are not supported.

public class DefaultFieldValueSpecAtomicTest extends TestCase {
    private static final String NAME_1 = "x";
    private static final String NAME_2 = "y";
    private static final Object VALUE_1 = new Object();
    private static final Object VALUE_2 = new Object();
    private static final FieldValueSpec FIELD_VALUE_SPEC_1 = new DefaultFieldValueSpec("field1", new Integer(77));
    private static final FieldValueSpec FIELD_VALUE_SPEC_2 = new DefaultFieldValueSpec("field7", "Is absolute zero cold enough?");

    public void testMarker() {
        assertTrue(Immutable.class.isAssignableFrom(DefaultFieldValueSpec.class));
    }

    public void testNullsIllegalInConstructor() {
        checkNullsIllegalInConstructor(null, VALUE_1);
        checkNullsIllegalInConstructor(NAME_1, null);
    }

    public void testCreate() {
        checkCreate(NAME_1, VALUE_1);
        checkCreate(NAME_2, VALUE_2);
    }

    public void testHashcode() {
        assertEquals(42, FIELD_VALUE_SPEC_1.hashCode());
        // FIXME: SC502 Triangulate.
    }

    public void testToString() {
        checkToString("DefaultFieldValueSpec[name=field1,value=77]", FIELD_VALUE_SPEC_1);
        checkToString("DefaultFieldValueSpec[name=field7,value=Is absolute zero cold enough?]", FIELD_VALUE_SPEC_2);
    }

    private void checkToString(String expected, FieldValueSpec spec) {
        assertEquals(expected, spec.toString());
    }

    private void checkCreate(String name, Object value) {
        FieldValueSpec fieldValue = new DefaultFieldValueSpec(name, value);
        assertEquals(name, fieldValue.getName());
        assertEquals(value, fieldValue.getValue());
    }

    private void checkNullsIllegalInConstructor(String name, Object value) {
        try {
            new DefaultFieldValueSpec(name, value);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
