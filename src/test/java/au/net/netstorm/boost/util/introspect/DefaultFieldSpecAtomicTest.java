package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.fixture.ImmutableTestUtil;
import junit.framework.TestCase;

// FIXME: SC501 DefaultFieldTypeSpec is just a data object!!!
public class DefaultFieldSpecAtomicTest extends TestCase {
    private static final String METHOD_NAME_1 = "testMethod";
    private static final Class METHOD_TYPE_1 = Object.class;
    private static final String METHOD_NAME_2 = "methodTwo";
    private static final Class METHOD_TYPE_2 = String.class;

    // FIXME: SC501 This should be failing because the names of the fields no longer match the actual fields.
    public void testIsImmutable() {
        ImmutableTestUtil.checkIsImmutableObject(DefaultFieldSpec.class, new DefaultFieldSpec[]{
            new DefaultFieldSpec("s", String.class),
            new DefaultFieldSpec("aClass", Class.class)
        });
    }

    public void testFieldTypeSpec() {
        checkFieldTypeSpec(METHOD_NAME_1, METHOD_TYPE_1);
        checkFieldTypeSpec(METHOD_NAME_2, METHOD_TYPE_2);
    }

    // FIXME: SC501 Remove this.
//    public void testNullsAreEvil() {
//        checkFailOnNull(null, METHOD_TYPE_1);
//        checkFailOnNull(METHOD_TYPE_1, null);
//    }

    public void checkFieldTypeSpec(String methodName, Class methodType) {
        FieldSpec spec = new DefaultFieldSpec(methodName, methodType);
        assertEquals(methodName, spec.getName());
        assertEquals(methodType, spec.getType());
    }

//    private void checkFailOnNull(Object methodName, Class methodType) {
//        CallSpec callSpec = new CallSpec("checkFieldTypeSpec", new Class[]{String.class, Class.class}, new Object[]{methodName, methodType});
//        ThrowAssert.assertThrows(IllegalArgumentException.class, this, callSpec);
//    }
}
