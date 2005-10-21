package au.net.netstorm.boost.ioc;

import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.reflect.ReflectMaster;
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
    private final ReflectMaster reflect = new DefaultReflectMaster();

    public void testResolve() throws Exception {
        checkResolve(createMultiField(), FIELD_NAME_SIZE, INTEGER_5);
        checkResolve(createMultiField(), FIELD_NAME_HEAD, "HEAD");
        checkResolve(createMultiField(), FIELD_NAME_TAIL, "TAIL");
    }

    private Object createMultiField() {
        return reflect.create(TestSubjects.MultiField.class);
    }

    public void testIllegalFieldNames() {
        checkException(NAME_HAS_SPACES);
        checkException(NAME_HAS_ILLEGAL_CHARACTERS);
        checkException(NAME_STARTS_WITH_NUMBER);
        checkException(NAME_IS_BLANK);
        checkException(NAME_STARTS_WITH_SPACE);
    }

// FIXME: SC501 COMPONENT FACTORY:
//    public void failIfFieldAlreadyInitialized() throws FieldAlreadyInitializedException {
//        Object ref = reflect.create(TestSubjects.FieldAlreadyInitialized.class);
//        FieldSpec fieldSpec = new DefaultFieldSpec("integer", new Integer(8));
//        resolver.resolve(ref, fieldSpec);
//    }

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
        resolver.resolve(createMultiField(), fieldValueSpec);
    }

    private void checkResolve(Object ref, String fieldName, Object value) throws Exception {
        assertEquals(null, ReflectTestUtil.getInstanceFieldValue(ref, fieldName));
        FieldValueSpec fieldValueSpec = new DefaultFieldValueSpec(fieldName, value);
        resolver.resolve(ref, fieldValueSpec);
        assertEquals(value, ReflectTestUtil.getInstanceFieldValue(ref, fieldName));
    }

    private void checkException(String name) {
        try {
            FieldValueSpec spec = new DefaultFieldValueSpec(name, VALUE_1);
            resolver.resolve(createMultiField(), spec);
            // FIXME: SC501 Drop simian back down to 2 - chokes on the next 2 lines right now.
            fail();
        } catch (IocException expected) {
        }
    }
}
