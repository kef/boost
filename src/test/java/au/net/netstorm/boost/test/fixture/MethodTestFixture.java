package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Method;

import au.net.netstorm.boost.test.reflect.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

// FIX SC517 ? public.
// FIX SC517 interface.

final class MethodTestFixture {
    static final String GETTER_PREFIX = "get"; // FIX SC517 Make public or private
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();
    private final Method method;

    MethodTestFixture(Method method) {
        this.method = method;
    }

    public static Method[] getDeclaredMethods(Object instance) {
        Class cls = instance.getClass();
        return cls.getDeclaredMethods();
    }

    public static void checkMethods(Object instance, FieldSpec[] newArgTypes) {
        Method[] methods = MethodTestFixture.getDeclaredMethods(instance);
        checkNumberOfMethods(newArgTypes, methods);
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MethodTestFixture fixture = new MethodTestFixture(method);
            fixture.checkMethod();
        }
    }

    private void checkMethod() {
        boolean pubLic = modifier.isPublic(method);
        String name = method.getName();
        if (!pubLic) Assert.fail("Method must be public: " + name);
        if (!methodNameIsGetter()) Assert.fail("Method must be getXxxx" + name);
    }

    private static void checkNumberOfMethods(FieldSpec[] newArgTypes, Method[] methods) {
        Assert.assertEquals("The number of methods must exactly match the number of arguments.", newArgTypes.length, methods.length);
    }

    private boolean methodNameIsGetter() {
        String name = method.getName();
        return name.startsWith(GETTER_PREFIX) && (name.length() > MemberTestFixture.GET_LENGTH);
    }
}
