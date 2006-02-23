package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

// FIXME: SC509 Merge with ReflectTestUtil.
// FIXME: SC042 Interfacise.

public final class ReflectionTestUtil {
    private static final String[] EXCLUSIONS = {"hashCode", "getClass", "equals", "toString", "wait", "notify", "notifyAll"};
    public static final ReflectionTestUtil INSTANCE = new ReflectionTestUtil(); // FIXME: SC042 Roll into instance.

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

    // FIXME: SC042 Given the current state of affairs, this looks like it belongs in ClassPropertiesTestUtil.
    public void checkSynchronized(Class type) {
        Method[] methods = type.getMethods();
        for (int i = 0; i < methods.length; i++) {
            checkSynchronized(methods[i]);
        }
    }

    private void checkSynchronized(Method method) {
        String name = method.getName();
        if (isExclusion(name)) {
            return;
        }
        int modifiers = method.getModifiers();
        Assert.assertTrue("" + method, Modifier.isSynchronized(modifiers));
    }

    private boolean isExclusion(String methodName) {
        for (int i = 0; i < EXCLUSIONS.length; i++) {
            if (methodName.equals(EXCLUSIONS[i])) {
                return true;
            }
        }
        return false;
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        try {
            return method.invoke(invokee, parameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
