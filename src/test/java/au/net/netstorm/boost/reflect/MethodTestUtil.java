package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;

// FIXME: SC999 Remove.  Just testing cruise build email messages.
public interface MethodTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);
    Class getThrowsType(Method method);
}
