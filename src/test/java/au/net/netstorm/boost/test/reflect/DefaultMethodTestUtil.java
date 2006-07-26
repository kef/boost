package au.net.netstorm.boost.test.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeReflect;
import junit.framework.Assert;

public class DefaultMethodTestUtil implements MethodTestUtil {
    private final EdgeReflect reflectEdge = EdgeReflect.EDGE_REFLECT;

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    public Class getThrowsType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        Assert.assertTrue(name + "() must throw a single exception.", exceptions.length == 1);
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
        return reflectEdge.invoke(method, invokee, parameters);
    }

    private boolean matches(Method method, String methodName) {
        String name = method.getName();
        return name.equals(methodName);
    }
}
