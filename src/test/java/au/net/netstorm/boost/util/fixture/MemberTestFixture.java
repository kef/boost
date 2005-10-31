package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import au.net.netstorm.boost.util.type.Immutable;
import junit.framework.Assert;

class MemberTestFixture {
    private static final ReflectEdge REFLECT_EDGE = ReflectEdge.INSTANCE;
    private final Object instance;
    private final Map fieldMap;
    static final int GET_LENGTH = MethodTestFixture.GETTER_PREFIX
            .length();

    MemberTestFixture(Object instance) {
        this.instance = instance;
        fieldMap = createFieldMap();
    }

    static void checkMembers(Object instance, FieldSpec[] newArgTypes, Object[] parameters) {
        Method[] methods = MethodTestFixture.getDeclaredMethods(instance);
        for (int i = 0; i < methods.length; i++) {
            MemberTestFixture memberFixture = new MemberTestFixture(instance);
            memberFixture.checkMember(newArgTypes[i], parameters[i]);
            memberFixture.checkDataProperty(methods[i], memberFixture.getParameter(getFieldName(methods[i])));
        }
    }

    private void checkMember(FieldSpec arg, Object expectedValue) {
        try {
            instance.getClass()
                    .getDeclaredField(arg.getName());
            Object actualValue = getParameter(arg.getName());
            checkFieldImmutable(expectedValue, actualValue, arg);
        } catch (NoSuchFieldException e) {
            Assert.fail("Field " + arg.getName() + " is not found with the correct type " + arg.getType());
        }
    }

    private Object getParameter(String fieldName) {
        try {
            Field field = (Field) fieldMap.get(fieldName);
            field.setAccessible(true);
            return field.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkDataProperty(Method method, Object expectedValue) {
        FieldValueSpec expectedFS = new DefaultFieldValueSpec(method.getName(), expectedValue);
        Object actualValue = REFLECT_EDGE.tryInvoke(method, instance);
        FieldValueSpec actualFS = new DefaultFieldValueSpec(method.getName(), actualValue);
        Assert.assertEquals("Method '" + method.getName() + "' does not return an equal value from one of the constructor parameters", expectedFS, actualFS);
        ReflectTestUtil.checkPrivateFinalField(instance.getClass(), getFieldName(method));
        checkFieldImmutable(expectedValue, actualValue, new DefaultFieldSpec(getFieldName(method), method.getReturnType()));
    }

    private Map createFieldMap() {
        Field[] fields = instance.getClass()
                .getDeclaredFields();
        Map fieldMap = new HashMap();
        for (int i = 0; i < fields.length; i++) fieldMap.put(fields[i].getName(), fields[i]);
        return fieldMap;
    }

    private static String getFieldName(Method method) {
        String name = method.getName()
                .substring(GET_LENGTH);
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }

    // FIXME: SC509 What about complex objects that have references to other objects. Make sure that they use deep copy and not just shallow.
    private static void checkFieldImmutable(Object expectedValue, Object actualValue, FieldSpec fieldSpec) {
        boolean isImmutable = isImmutableClass(fieldSpec.getType()) || (expectedValue != actualValue);
        Assert.assertTrue("The field '" + fieldSpec.getName() + "' needs to be either Immutable or needs to copy the values internally", isImmutable);
    }

    private static boolean isImmutableClass(Class returnType) {
        return (Class.class.isAssignableFrom(returnType)) || (String.class.isAssignableFrom(returnType)) || (Immutable.class.isAssignableFrom(returnType));
    }
}
