package au.net.netstorm.boost.sniper.reflect.util;

import java.lang.reflect.Method;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.gunge.introspect.DefaultMethodSpec;
import au.net.netstorm.boost.gunge.introspect.MethodSpec;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeMethod;
import junit.framework.Assert;

public class DefaultMethodTestUtil implements MethodTestUtil {
    private final EdgeMethod edgeMethod = new DefaultEdgeMethod();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private static final Object NO_INSTANCE = null;

    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(false, invokee, methodName, parameters);
        return invoke(invokee, method, parameters);
    }

    public Object invoke(Class cls, String methodName, Object[] parameters) {
        Method method = getMethod(false, cls, methodName, parameters);
        return edgeMethod.invoke(method, NO_INSTANCE, parameters);
    }

    public Object invokeExact(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(true, invokee, methodName, parameters);
        return invoke(invokee, method, parameters);
    }

    public Class getThrowsType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        if (exceptions.length != 1) fail(name + "() must throw a single exception.");
        return exceptions[0];
    }

    private Method getMethod(boolean exact, Object instance, String methodName, Object[] parameters) {
        Class type = instance.getClass();
        return getMethod(exact, type, methodName, parameters);
    }

    private Method getMethod(boolean exact, Class type, String methodName, Object[] parameters) {
        Class[] paramTypes = convertToTypes(parameters);
        MethodSpec spec = new DefaultMethodSpec(methodName, paramTypes);
        if (exact) return reflector.getMethodWithExactParams(type, spec);
        else return reflector.getMethod(type, spec);
    }

    private Class[] convertToTypes(Object[] parameters) {
        if (parameters == null) return new Class[0];
        Class[] types = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            types[i] = parameters[i].getClass();
        }
        return types;
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        method.setAccessible(true);
        return edgeMethod.invoke(method, invokee, parameters);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
