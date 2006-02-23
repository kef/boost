package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

// FIXME: SC509 Merge with ReflectTestUtil.
// FIXME: SC042 Interfacise.
// FIXME: SC042 Use edgers to knock out exception catching.

// FIXME: SC042 Perform a quick check to see who _really_ uses this.

public final class DefaultReflectionTestUtil implements ReflectionTestUtil {
    public static final ReflectionTestUtil INSTANCE = new DefaultReflectionTestUtil(); // FIXME: SC042 Roll into instance.

    public Method getMethod(Object instance, String methodName) {
        Class type = instance.getClass();
        return getMethod(type, methodName);
    }

    public Method getMethod(Class type, String methodName) {
        Method[] methods = type.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName()
                    .equals(methodName)) {
                return method;
            }
        }
        throw new IllegalStateException("No method " + methodName + " on " + type);
    }

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        try {
            return method.invoke(invokee, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
