package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.MethodSpec;

class DefaultReflectMethodMaster implements ReflectMethodMaster {
    public Method getMethod(Class cls, MethodSpec method) {
        checkNotNull(cls);
        checkNotNull(method);
        return doGetMethod(cls, method);
    }

    private Method doGetMethod(Class cls, MethodSpec targetMethod) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method sourceMethod = methods[i];
            if (methodsMatch(sourceMethod, targetMethod)) return sourceMethod;
        }
        throw new NoSuchMethodError(targetMethod.toString());
    }

    private boolean methodsMatch(Method sourceMethod, MethodSpec targetMethod) {
        String name = targetMethod.getName();
        if (!methodNamesMatch(sourceMethod, name)) return false;
        Class[] params = targetMethod.getParams();
        if (!paramsMatch(sourceMethod, params)) return false;
        return true;
    }

    private boolean methodNamesMatch(Method sourceMethod, String targetMethodName) {
        return sourceMethod.getName()
                .equals(targetMethodName);
    }

    private boolean paramsMatch(Method sourceMethod, Class[] parameterTypes) {
        Class[] params = sourceMethod.getParameterTypes();
        if (parameterTypes.length != params.length) return false;
        for (int i = 0; i < params.length; i++) {
            if (!paramMatches(params[i], parameterTypes[i])) return false;
        }
        return true;
    }

    private boolean paramMatches(Class sourceParam, Class targetParam) {
        return sourceParam.isAssignableFrom(targetParam);
    }

    private void checkNotNull(Object param) {
        if (param == null) throw new IllegalArgumentException();
    }
}
