package au.net.netstorm.boost.test.reflect.util;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import junit.framework.Assert;

import java.lang.reflect.Method;

public class DefaultMethodTestUtil implements MethodTestUtil {
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    public Class getThrowsType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        if (exceptions.length != 1) fail(name + "() must throw a single exception.");
        return exceptions[0];
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
        method.setAccessible(true);
        return edgeMethod.invoke(method, invokee, parameters);
    }

    private boolean matches(Method method, String methodName) {
        String name = method.getName();
        return name.equals(methodName);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
