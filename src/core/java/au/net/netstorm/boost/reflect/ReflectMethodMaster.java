package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.util.introspect.MethodSpec;

import java.lang.reflect.Method;

public interface ReflectMethodMaster {
    Method getMethod(Class cls, MethodSpec method);
}
