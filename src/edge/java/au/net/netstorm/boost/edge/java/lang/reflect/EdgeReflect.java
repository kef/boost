package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// FIX SC600 Move all these methods out.

public interface EdgeReflect {
    // FIX SC600 EdgeField
    Object getFieldValue(Field field, Object ref);

    // FIX SC600 EdgeField
    void setFieldValue(Field field, Object ref, Object value);

    // FIX SC600 EdgeConstructor.
    Object newInstance(Constructor constructor, Object[] parameters);

    // FIX SC600 EdgeMethod.
    Object invoke(Method method, Object instance);

    // FIX SC600 EdgeMethod.
    Object invoke(Method method, Object instance, Object[] args);
}
