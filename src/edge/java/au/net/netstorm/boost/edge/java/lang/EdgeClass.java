package au.net.netstorm.boost.edge.java.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface EdgeClass {
    Class forName(String className);

    Object newInstance(Class cls);

    Constructor getConstructor(Class cls, Class[] parameterTypes);

    Method getMethod(Class cls, String methodName, Class[] parameterTypes);

    Method getDeclaredMethod(Class cls, String methodName, Class[] parameterTypes);

    Field getDeclaredField(Class cls, String fieldName);

    Field[] getDeclaredFields(Class cls);
}
