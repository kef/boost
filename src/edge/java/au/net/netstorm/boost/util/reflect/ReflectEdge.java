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

    Object tryInvoke(Method method, Object instance);

    Object tryInvoke(Method method, Object instance, Object[] args);
}
