package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// SUGGEST: This stuff will probably follow the same sort of pattern as the MemberTestUtil, ClassTestUtil...
// SUGGEST: Maybe follow the java.lang. package structure.
// FIX SC600 Move all these methods out.

public interface EdgeReflect {
    Object getFieldValue(Field field, Object ref);

    void setFieldValue(Field field, Object ref, Object value);

    Object newInstance(Constructor constructor, Object[] parameters);

    Object invoke(Method method, Object instance);

    Object invoke(Method method, Object instance, Object[] args);
}
