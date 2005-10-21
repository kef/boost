package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ReflectEdge {
    ReflectEdge INSTANCE = new DefaultReflectEdge();

    Object get(Field field, Object ref);

    Object newInstance(Constructor constructor, Object[] parameters);

    Class forName(String className);

    Method getMethod(Class cls, String methodName, Class[] parameterTypes);

    // FIXME: SC501 Fix methods which throw an exception.  This is not part of the "edge" contract.
    Object invoke(Method method, Object instance) throws Exception;

    Object tryInvoke(Method method, Object instance);

    Object invoke(Method method, Object instance, Object[] args) throws Exception;

    Object tryInvoke(Method method, Object instance, Object[] args);
}
