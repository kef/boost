package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

// FIXME: SC509 Merge with ReflectTestUtil.
// FIXME: SC042 Interfacise.
// FIXME: SC042 Use edgers to knock out exception catching.
// FIXME: SC042 Remove train wrecks

// FIXME: SC042 Perform a quick check to see who _really_ uses this.

public final class DefaultReflectionTestUtil implements ReflectionTestUtil {
    private final ReflectEdge edge = ReflectEdge.INSTANCE;

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    private Method getMethod(Object instance, String methodName) {
        Class type = instance.getClass();
        return getMethod(type, methodName);
    }

    private Method getMethod(Class type, String methodName) {
        Method[] methods = type.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (matches(method, methodName)) return method;
        }
        throw new IllegalStateException("No method " + methodName + " on " + type);
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        return edge.invoke(method, invokee, parameters);
    }

    private boolean matches(Method method, String methodName) {
        String name = method.getName();
        return name.equals(methodName);
    }
}
