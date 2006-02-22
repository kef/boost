package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import junit.framework.Assert;

// FIXME: SC042 ? public.
// FIXME: SC042 interface.
final class MethodTestFixture {
    static final String GETTER_PREFIX = "get"; // FIXME: SC042 Make public or private
    private final ReflectTestUtil reflector = new DefaultReflectTestUtil();
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
        boolean pubLic = reflector.methodIsPublic(method);
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
