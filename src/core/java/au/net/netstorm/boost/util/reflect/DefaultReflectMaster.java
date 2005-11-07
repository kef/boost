package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.introspect.MethodSpec;

// FIXME: SC506 ? INSTANCE as way to access this sucker.
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

    public FieldValueSpec[] getInstanceFields(Object ref) {
        return fieldMaster.getInstanceFields(ref);
    }
}
