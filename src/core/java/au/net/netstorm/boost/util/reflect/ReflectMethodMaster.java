package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.MethodSpec;

public interface ReflectMethodMaster {
    Method getMethod(Class cls, MethodSpec method);
}
