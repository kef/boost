package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.DefaultFieldTestChecker;
import au.net.netstorm.boost.util.reflect.DefaultFieldTestUtil;
import au.net.netstorm.boost.util.reflect.FieldTestChecker;
import au.net.netstorm.boost.util.reflect.FieldTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.Assert;

// FIXME: SC050 Tidy up this pile of bollocks code!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// FIXME: SC050 Again and again we just keep getting nailed by this HEAP OF !!!!!!!!!
// FIXME: SC050 Slowly, Slowly.
// FIXME: SC050 Instancise first.
// FIXME: SC050 Extract interface next.
// FIXME: SC050 IN FACT THIS IS SUCH A RUBBISH WE JUST GO A TOTAL REWRITE!!!!!!!!!!!!!!!!!!!!!
// FIXME: SC517 Make test fixture thingies final.
// FIXME: SC517 This will have to flick out into another card.
//
//
//
//
// ---------------------------------------- FIXME: SC517  FROZEN -----------------------------------
//
//
//
//

final class MemberTestFixture {
    private static final ReflectEdge REFLECT_EDGE = ReflectEdge.INSTANCE;
    static final int GET_LENGTH = MethodTestFixture.GETTER_PREFIX
            .length(); // FIXME: SC517 Make this public or private.
    private final FieldTestChecker fielder = new DefaultFieldTestChecker();
    private final FieldTestUtil fields = new DefaultFieldTestUtil();
    private final Object instance;
    private final Map fieldMap;

    MemberTestFixture(Object instance) {
        this.instance = instance;
        // FIXME: SC050 This can go.  People guessing what might be needed.  Over engineering.  Just get the field we want when we want!!!!
        fieldMap = createFieldMap();
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
            memberFixture.checkDataProperty(method, memberFixture.getParameter(name));
        }
    }

    private void checkMember(FieldSpec arg, Object expectedValue) {
        try {
            Class cls = instance.getClass();
            cls.getDeclaredField(arg.getName());
            String name = arg.getName();
            Object actualValue = getParameter(name);
            checkFieldImmutable(expectedValue, actualValue, arg);
        } catch (NoSuchFieldException e) {
            Assert.fail("Field " + arg.getName() + " is not found with the correct type " + arg.getType());
        }
    }

    // FIXME: SC042 Inline?
    private Object getParameter(String fieldName) {
        return fields.getInstance(instance, fieldName);
    }

    private void checkDataProperty(Method method, Object expectedValue) {
        String methodName = method.getName();
        FieldValueSpec expectedFs = new DefaultFieldValueSpec(methodName, expectedValue);
        Object actualValue = REFLECT_EDGE.invoke(method, instance);
        FieldValueSpec actualFs = new DefaultFieldValueSpec(methodName, actualValue);
        Assert.assertEquals("Method '" + methodName + "' does not return an equal value from one of the constructor parameters", expectedFs, actualFs);
        fielder.checkPrivateFinalField(instance.getClass(), getFieldName(method));
        checkFieldImmutable(expectedValue, actualValue, new DefaultFieldSpec(getFieldName(method), method.getReturnType()));
    }

    private Map createFieldMap() {
        Class cls = instance.getClass();
        Field[] fields = cls.getDeclaredFields();
        Map fieldMap = new HashMap();
        for (int i = 0; i < fields.length; i++) fieldMap.put(fields[i].getName(), fields[i]);
        return fieldMap;
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

    // FIXME: SC509 What about complex objects that have references to other objects. Make sure that they use deep copy and not just shallow.
    private static void checkFieldImmutable(Object expectedValue, Object actualValue, FieldSpec fieldSpec) {
        Class type = fieldSpec.getType();
        boolean isImmutable = isImmutable(type) || (expectedValue != actualValue);
        Assert.assertTrue("The field '" + fieldSpec.getName() + "' needs to be either Immutable or needs to copy the values internally", isImmutable);
    }

    // FIXME: SC509 This is a "member test fixture" for crying out loud.  What is it doing checking return types PK?
    private static boolean isImmutable(Class type) {
        return (Class.class.isAssignableFrom(type)) || (String.class.isAssignableFrom(type)) || (Immutable.class.isAssignableFrom(type));
    }
}
