package au.net.netstorm.boost.edge.java.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface EdgeClass {
    Class forName(String className);

    Object newInstance(Class cls);

    Method getMethod(Class cls, String methodName, Class[] parameterTypes);

    Method getDeclaredMethod(Class cls, String methodName, Class[] parameterTypes);

    Field getDeclaredField(Class cls, String fieldName);
}
