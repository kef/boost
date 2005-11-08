package au.net.netstorm.boost.ioc;

import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import junit.framework.TestCase;

public class DefaultFieldResolverAtomicTest extends TestCase {
    private static final Integer INTEGER_5 = new Integer(5);
    private static final String NAME_1 = "x";
    private static final Object VALUE_1 = new Object();
    private static final String NAME_DOES_NOT_EXIST = "noFieldHere";
    private static final String NAME_HAS_SPACES = "has spaces";
    private static final String NAME_HAS_ILLEGAL_CHARACTERS = "field()";
    private static final String NAME_STARTS_WITH_NUMBER = "2";
    private static final String NAME_IS_BLANK = "";
    private static final String NAME_STARTS_WITH_SPACE = " field";
    private static final String FIELD_NAME_HEAD = "head";
    private static final String FIELD_NAME_TAIL = "tail";
    private static final String FIELD_NAME_SIZE = "size";
    private static final FieldValueSpec FIELD_VALUE_SPEC = new DefaultFieldValueSpec(NAME_1, VALUE_1);
    private static final FieldValueSpec FIELD_VALUE_SPEC_INCOMPATIBLE_TYPE = new DefaultFieldValueSpec(FIELD_NAME_HEAD, INTEGER_5);
    private static final FieldValueSpec FIELD_VALUE_NO_SUCH_FIELD_VALUE = new DefaultFieldValueSpec(NAME_DOES_NOT_EXIST, VALUE_1);
    private final FieldResolver resolver = new DefaultFieldResolver();

    public void testResolve() throws Exception {
        checkResolve(FIELD_NAME_SIZE, INTEGER_5);
        checkResolve(FIELD_NAME_HEAD, "HEAD");
        checkResolve(FIELD_NAME_TAIL, "TAIL");
    }

    // FIXME: SC502 Push this check into FieldValue object.
    public void testIllegalFieldNames() {
        checkException(NAME_HAS_SPACES);
        checkException(NAME_HAS_ILLEGAL_CHARACTERS);
        checkException(NAME_STARTS_WITH_NUMBER);
        checkException(NAME_IS_BLANK);
        checkException(NAME_STARTS_WITH_SPACE);
    }

// FIXME: SC506
    public void testFailIfFieldAlreadyInitialized() {
        // FIXME: SC502 Triangulate.
        Object ref = new TestSubjects.FieldAlreadyInitialized();
        FieldValueSpec fieldValue = new DefaultFieldValueSpec("integer", new Integer(8));
        try {
            resolver.resolve(ref, fieldValue);
            fail();
        } catch (FieldAlreadyInitializedException expected) {
        }
    }

    // FIXME: SC502 Convert to good old try / catch.
    public void failNullInResolve() throws IllegalArgumentException {
        resolver.resolve(null, FIELD_VALUE_SPEC);
    }

    public void failIncompatibleType() throws IocException {
        resolve(FIELD_VALUE_SPEC_INCOMPATIBLE_TYPE);
    }

    public void failNoSuchField() throws IocException {
        resolve(FIELD_VALUE_NO_SUCH_FIELD_VALUE);
    }

    private void resolve(FieldValueSpec fieldValueSpec) {
        resolver.resolve(new TestSubjects.MultiField(), fieldValueSpec);
    }

    private void checkResolve(String fieldName, Object value) throws Exception {
        Object ref = new TestSubjects.MultiField();
        assertEquals(null, getInstanceFieldValue(ref, fieldName));
        FieldValueSpec fieldValueSpec = new DefaultFieldValueSpec(fieldName, value);
        resolver.resolve(ref, fieldValueSpec);
        assertEquals(value, getInstanceFieldValue(ref, fieldName));
    }

    private void checkException(String name) {
        try {
            FieldValueSpec spec = new DefaultFieldValueSpec(name, VALUE_1);
            resolver.resolve(new TestSubjects.MultiField(), spec);
            fail();
        } catch (IocException expected) { }
    }

    private Object getInstanceFieldValue(Object ref, String fieldName) {
        return ReflectTestUtil.getInstanceFieldValue(ref, fieldName);
    }
}
