package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectTestUtil;
import junit.framework.Assert;

class MethodTestFixture {
    static final String GETTER_PREFIX = "get";
    private final Method method;

    MethodTestFixture(Method method) {
        this.method = method;
    }

    static Method[] getDeclaredMethods(Object instance) {
        return instance.getClass().getDeclaredMethods();
    }

    static void checkMethods(Object instance, FieldSpec[] newArgTypes) {
        Method[] methods = MethodTestFixture.getDeclaredMethods(instance);
        checkNumberOfMethods(newArgTypes, methods);
        for (int i = 0; i < methods.length; i++) {
            new MethodTestFixture(methods[i]).checkMethod();
        }
    }

    private void checkMethod() {
        if (!new DefaultReflectTestUtil().methodIsPublic(method)) Assert.fail("Method must be public: " + method.getName());
        if (!methodNameIsGetter()) Assert.fail("Method must be getXxxx" + method.getName());
    }

    private static void checkNumberOfMethods(FieldSpec[] newArgTypes, Method[] methods) {
        Assert.assertEquals("The number of methods must exactly match the number of arguments.", newArgTypes.length, methods.length);
    }

    private boolean methodNameIsGetter() {
        String name = method.getName();
        return name.startsWith(GETTER_PREFIX) && (name.length() > MemberTestFixture.GET_LENGTH);
    }
}
