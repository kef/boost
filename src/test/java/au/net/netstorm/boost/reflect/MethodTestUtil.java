package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);

    Class getThrowsType(Method method);
}
