package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.introspect.MethodSpec;
import au.net.netstorm.boost.nursery.reflect.DefaultReflectMethodMaster;

// SUGGEST Use "composer" when it is ready.
public final class DefaultReflectMaster implements ReflectMaster {
    private final ReflectObjectMaster objectMaster = new DefaultReflectObjectMaster();
    private final ReflectMethodMaster methodMaster = new DefaultReflectMethodMaster();
    private final ReflectFieldMaster fieldMaster = new DefaultReflectFieldMaster();

    public Constructor getConstructor(Class cls) {
        return objectMaster.getConstructor(cls);
    }

    public Method getMethod(Class cls, MethodSpec method) {
        return methodMaster.getMethod(cls, method);
    }

    public Method getMethodWithExactParams(Class cls, MethodSpec method) {
        return methodMaster.getMethodWithExactParams(cls, method);
    }

    public String[] getPublicMethodNames(Object ref) {
        return methodMaster.getPublicMethodNames(ref);
    }

    public Method[] getPublicMethods(Object ref) {
        return methodMaster.getPublicMethods(ref);
    }

    public FieldValueSpec[] getInstanceFields(Object ref) {
        return fieldMaster.getInstanceFields(ref);
    }
}
