package au.net.netstorm.boost.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// SUGGEST: This stuff will probably follow the same sort of pattern as the MemberTestUtil, ClassTestUtil...
// SUGGEST: Maybe follow the java.lang. package structure.

public interface EdgeReflect {
    EdgeReflect INSTANCE = new DefaultEdgeReflect();

    Object getFieldValue(Field field, Object ref);

    void setFieldValue(Field field, Object ref, Object value);

    Field getDeclaredField(Class cls, String fieldName);

    Object newInstance(Class cls);

    Object newInstance(Constructor constructor, Object[] parameters);

    Class forName(String className);

    Method getMethod(Class cls, String methodName, Class[] parameterTypes);

    Object invoke(Method method, Object instance);

    Object invoke(Method method, Object instance, Object[] args);
}
