package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.util.introspect.MethodSpec;

class DefaultReflectMethodMaster implements ReflectMethodMaster {
    public Method getMethod(Class cls, MethodSpec method) {
        checkNotNull(cls);
        checkNotNull(method);
        return doGetMethod(cls, method);
    }

    public String[] getPublicMethodNames(Object ref) {
        List publicNames = extractPublicMethods(ref);
        return (String[]) publicNames.toArray(new String[]{});
    }

    private List extractPublicMethods(Object ref) {
        Class cls = ref.getClass();
        Method[] methods = cls.getDeclaredMethods();
        List actualMethodNames = new ArrayList();
        for (int i = 0; i < methods.length; i++) addPublicMethods(methods[i], actualMethodNames);
        return actualMethodNames;
    }

    private void addPublicMethods(Method method, List actualMethodNames) {
        if (isPublic(method)) {
            String name = method.getName();
            actualMethodNames.add(name);
        }
    }

    private boolean isPublic(Method method) {
        int modifiers = method.getModifiers();
        return Modifier.isPublic(modifiers);
    }

    private Method doGetMethod(Class cls, MethodSpec targetMethod) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methodsMatch(methods[i], targetMethod)) return methods[i];
        }
        throw new NoSuchMethodError(targetMethod.toString());
    }

    private boolean methodsMatch(Method sourceMethod, MethodSpec targetMethod) {
        String name = targetMethod.getName();
        if (!methodNamesMatch(sourceMethod, name)) return false;
        Class[] params = targetMethod.getParams();
        return paramsMatch(sourceMethod, params);
    }

    private boolean methodNamesMatch(Method sourceMethod, String targetMethodName) {
        String methodName = sourceMethod.getName();
        return methodName.equals(targetMethodName);
    }

    private boolean paramsMatch(Method sourceMethod, Class[] parameterTypes) {
        Class[] params = sourceMethod.getParameterTypes();
        if (parameterTypes.length != params.length) {
            return false;
        }
        for (int i = 0; i < params.length; i++) {
            if (!paramMatches(params[i], parameterTypes[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean paramMatches(Class sourceParam, Class targetParam) {
        return sourceParam.isAssignableFrom(targetParam);
    }

    private void checkNotNull(Object param) {
        if (param == null) {
            throw new IllegalArgumentException();
        }
    }
}
