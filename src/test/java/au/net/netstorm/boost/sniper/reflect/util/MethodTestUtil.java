package au.net.netstorm.boost.sniper.reflect.util;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    Object invoke(Object invokee, String name, Object[] parameters);

    Object invokeExact(Object invokee, String methodName, Object[] parameters);

    Class getThrowsType(Method method);

    Object invoke(Class cls, String methodName, Object[] parameters);
}
