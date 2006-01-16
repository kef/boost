package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.fixture.ImmutableTestUtil;
import junit.framework.TestCase;

// FIXME: SC509 DefaultFieldTypeSpec is just a data object!!!
public class DefaultFieldSpecAtomicTest extends TestCase {
    private static final String METHOD_NAME_1 = "testMethod";
    private static final Class METHOD_TYPE_1 = Object.class;
    private static final String METHOD_NAME_2 = "methodTwo";
    private static final Class METHOD_TYPE_2 = String.class;

    // FIXME: SC509 This should be failing because the names of the fields no longer match the actual fields.
    public void testIsImmutable() {
        // FIXME: SC050 The string values inside the fieldSpecs are not used.  This indicates the field specs are too much.  Sort this out.
        // FIXME: SC050 And while we're here, change "s" and "aClass" to something slightly more RELEVANT!
        DefaultFieldSpec f1 = new DefaultFieldSpec("s", String.class);
        DefaultFieldSpec f2 = new DefaultFieldSpec("aClass", Class.class);
        DefaultFieldSpec[] fields = {f1, f2};
        ImmutableTestUtil.checkIsImmutableObject(DefaultFieldSpec.class, fields);
    }

    public void testFieldTypeSpec() {
        checkFieldTypeSpec(METHOD_NAME_1, METHOD_TYPE_1);
        checkFieldTypeSpec(METHOD_NAME_2, METHOD_TYPE_2);
    }

    // FIXME: SC509 Remove this.
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
