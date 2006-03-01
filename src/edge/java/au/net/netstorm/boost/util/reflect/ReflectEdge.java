package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// FUTURE: This stuff will probably follow the same sort of pattern as the MemberTestUtil, ClassTestUtil...

public interface ReflectEdge {
    ReflectEdge INSTANCE = new DefaultReflectEdge();

    // FIXME: SC042 Reverse field ordering.  Same below.
    Object getFieldValue(Field field, Object ref);

    void setFieldValue(Field field, Object ref, Object value);

    Object newInstance(Class cls);

    Object newInstance(Constructor constructor, Object[] parameters);

    Class forName(String className);

    Method getMethod(Class cls, String methodName, Class[] parameterTypes);

    Object invoke(Method method, Object instance);

    Object invoke(Method method, Object instance, Object[] args);
}
