package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);

    Class getThrowsType(Method method);
}
