package au.net.netstorm.boost.test.reflect.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import junit.framework.Assert;

// FIX 2000 Can we roll this class back so we don't do the regexp stuff anymore?
public class DefaultMethodTestUtil implements MethodTestUtil {
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    public Method[] getTestMethods(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        return findMethods(methods, "^test.*");
    }

    public Class getThrowsType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        if (exceptions.length != 1) fail(name + "() must throw a single exception.");
        return exceptions[0];
    }

    private Method getMethod(Object instance, String methodName) {
        Class cls = instance.getClass();
        Method[] methods = cls.getMethods();
        Method[] result = findMethods(methods, "^" + methodName + "$");
        if (result.length == 0) throw new IllegalStateException("No method " + methodName + " on " + cls);
        return result[0];
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        method.setAccessible(true);
        return edgeMethod.invoke(method, invokee, parameters);
    }

    private Method[] findMethods(Method[] methods, String regex) {
        List result = new ArrayList();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (matches(method, regex)) result.add(method);
        }
        return (Method[]) result.toArray(new Method[]{});
    }

    private boolean matches(Method method, String regex) {
        String name = method.getName();
        return name.matches(regex);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
