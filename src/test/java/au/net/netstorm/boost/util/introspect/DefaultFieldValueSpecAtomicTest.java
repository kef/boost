package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.TestCase;

// FIXME: SC501 Currently primitive types are not supported.

public class DefaultFieldValueSpecAtomicTest extends TestCase {
    private static final String NAME_1 = "x";
    private static final String NAME_2 = "y";
    private static final Object VALUE_1 = new Object();
    private static final Object VALUE_2 = new Object();

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
