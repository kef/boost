package au.net.netstorm.boost.reflect;

import junit.framework.TestCase;

// FIX SC010 Don't use JMock. Actually do use it now via new implicit mocking facilities.

public class DefaultReflectMasterAtomicTest extends TestCase {
//    private static final MethodSpec METHOD_SPEC = new MethodSpec("booleanValue", new Class[]{});
//    private static final FieldValueSpec[] FIELD_SPEC_ARRAY = new FieldValueSpec[]{new DefaultFieldValueSpec("name", "value")};

    // FIX SC509 Reinstate these tests.
    public void testFixThis() {
    }
//    public void testCreate() {
//        Mock mock = createMock(ReflectObjectMaster.class);
//        expectOneCallTo("create", mock).with(eq(String.class)).will(returnValue(""));
//        ReflectMaster master = createReflectMaster("objectMaster", mock.proxy());
//        master.create(String.class);
//    }
//
//    public void testGetConstructor() {
//        Mock mock = createMock(ReflectObjectMaster.class);
//        expectOneCallTo("getConstructor", mock).with(eq(Boolean.class)).will(returnValue(Boolean.class.getConstructors()[0]));
//        ReflectMaster master = createReflectMaster("objectMaster", mock.proxy());
//        master.getConstructor(Boolean.class);
//    }
//
//    public void testGetMethod() {
//        Mock mock = createMock(ReflectMethodMaster.class);
//        expectOneCallTo("getMethod", mock).with(eq(Boolean.class), eq(METHOD_SPEC)).will(returnValue(Boolean.class.getMethods()[0]));
//        ReflectMaster master = createReflectMaster("methodMaster", mock.proxy());
//        master.getMethod(Boolean.class, METHOD_SPEC);
//    }
//
//    public void testGetInstanceFields() {
//        Mock mock = createMock(ReflectFieldMaster.class);
//        expectOneCallTo("getInstanceFields", mock).with(eq(Boolean.TRUE)).will(returnValue(FIELD_SPEC_ARRAY));
//        ReflectMaster master = createReflectMaster("fieldMaster", mock.proxy());
//        master.getInstanceFields(Boolean.TRUE);
//    }
//
//    private ReflectMaster createReflectMaster(String fieldName, Object fieldValue) {
//        DefaultFieldValueSpec f1 = new DefaultFieldValueSpec(fieldName, fieldValue);
//        return (ReflectMaster) iocCreate(DefaultReflectMaster.class, new FieldValueSpec[]{f1});
//    }
}
