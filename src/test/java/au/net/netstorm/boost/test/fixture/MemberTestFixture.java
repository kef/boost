package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.test.reflect.checker.DefaultFieldTestChecker;
import au.net.netstorm.boost.test.reflect.checker.FieldTestChecker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.Assert;

// FIX SC050 Tidy up this pile of bollocks code!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// FIX SC050 Again and again we just keep getting nailed by this HEAP OF !!!!!!!!!
// FIX SC050 Slowly, Slowly.
// FIX SC050 Instancise first.
// FIX SC050 Extract interface next.
// FIX SC050 IN FACT THIS IS SUCH A RUBBISH WE JUST GO A TOTAL REWRITE!!!!!!!!!!!!!!!!!!!!!
// FIX SC517 Make test fixture thingies final.
// FIX SC517 This will have to flick out into another card.
//
//
//
//
// ---------------------------------------- FIX SC517  FROZEN -----------------------------------
//
//
//
//

final class MemberTestFixture {
    private static final EdgeMethod EDGE_METHOD = new DefaultEdgeMethod();
    static final int GET_LENGTH = MethodTestFixture.GETTER_PREFIX
            .length(); // FIX SC517 Make this public or private.
    private final FieldTestChecker fielder = new DefaultFieldTestChecker();
    private final FieldTestUtil fields = new DefaultFieldTestUtil();
    private final Object instance;

    MemberTestFixture(Object instance) {
        this.instance = instance;
    }

    public static void checkMembers(Object instance, FieldSpec[] fields, Object[] parameters) {
        Method[] methods = MethodTestFixture.getDeclaredMethods(instance);
        for (int i = 0; i < methods.length; i++) {
            Object parameter = parameters[i];
            Method method = methods[i];
            FieldSpec newArgType = fields[i];
            MemberTestFixture memberFixture = new MemberTestFixture(instance);
            memberFixture.checkMember(newArgType, parameter);
            String name = getFieldName(method);
            memberFixture.checkDataProperty(method, memberFixture.getFieldValue(name));
        }
    }

    private void checkMember(FieldSpec arg, Object expectedValue) {
        try {
            Class cls = instance.getClass();
            cls.getDeclaredField(arg.getName());
            String name = arg.getName();
            Object actualValue = getFieldValue(name);
            checkFieldImmutable(expectedValue, actualValue, arg);
        } catch (NoSuchFieldException e) {
            Assert.fail("Field " + arg.getName() + " is not found with the correct type " + arg.getType());
        }
    }

    private Object getFieldValue(String fieldName) {
        return fields.getInstance(instance, fieldName);
    }

    private void checkDataProperty(Method method, Object expectedValue) {
        String methodName = method.getName();
        FieldValueSpec expectedFs = new DefaultFieldValueSpec(methodName, expectedValue);
        method.setAccessible(true);
        Object actualValue = EDGE_METHOD.invoke(method, instance, null);
        FieldValueSpec actualFs = new DefaultFieldValueSpec(methodName, actualValue);
        Assert.assertEquals("Method '" + methodName + "' does not return an equal value from one of the constructor parameters", expectedFs, actualFs);
        fielder.checkPrivateFinalInstanceField(instance.getClass(), getFieldName(method));
        checkFieldImmutable(expectedValue, actualValue, new DefaultFieldSpec(getFieldName(method), method.getReturnType()));
    }

    private static String getFieldName(Method method) {
        String methodName = method.getName();
        String propertyName = methodName.substring(GET_LENGTH);
        char startChar = propertyName.charAt(0);
        String remainder = propertyName.substring(1);
        return lowerCase(startChar) + remainder;
    }

    private static char lowerCase(char startChar) {
        return Character.toLowerCase(startChar);
    }

    // FIX SC509 What about complex objects that have references to other objects. Make sure that they use deep copy and not just shallow.
    private static void checkFieldImmutable(Object expectedValue, Object actualValue, FieldSpec fieldSpec) {
        Class type = fieldSpec.getType();
        boolean isImmutable = isImmutable(type) || (expectedValue != actualValue);
        Assert.assertTrue("The field '" + fieldSpec.getName() + "' needs to be either Immutable or needs to copy the values internally", isImmutable);
    }

    // FIX SC509 This is a "member test fixture" for crying out loud.  What is it doing checking return types PK?
    private static boolean isImmutable(Class type) {
        return Class.class.isAssignableFrom(type) || String.class.isAssignableFrom(type) || Immutable.class.isAssignableFrom(type) || isPrimitiveWrapperImmutable(type);
    }

    private static boolean isPrimitiveWrapperImmutable(Class type) {
        return Boolean.class.isAssignableFrom(type) || Character.class.isAssignableFrom(type) || Byte.class.isAssignableFrom(type) || Short.class.isAssignableFrom(type) || Integer.class.isAssignableFrom(type) || Long.class.isAssignableFrom(type) || Float.class.isAssignableFrom(type) || Double.class.isAssignableFrom(type);
    }
}
