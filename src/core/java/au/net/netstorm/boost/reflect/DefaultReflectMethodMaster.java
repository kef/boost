package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.util.introspect.MethodSpec;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

class DefaultReflectMethodMaster implements ReflectMethodMaster {
    public Method getMethod(Class cls, MethodSpec method) {
        return getMethod(false, cls, method);
    }

    public Method getMethodWithExactParams(Class cls, MethodSpec method) {
        return getMethod(true, cls, method);
    }

    public String[] getPublicMethodNames(Object ref) {
        Method[] publics = getPublicMethods(ref);
        String[] names = new String[publics.length];
        for (int i = 0; i < publics.length; i++) {
            names[i] = publics[i].getName();
        }
        return names;
    }

    public Method[] getPublicMethods(Object ref) {
        Class cls = ref.getClass();
        List publicMethods = getPublicMethodList(cls);
        return (Method[]) publicMethods.toArray(new Method[0]);
    }

    private Method getMethod(boolean exact, Class cls, MethodSpec method) {
        checkNotNull(cls);
        checkNotNull(method);
        return doGetMethod(exact, cls, method);
    }

    private List getPublicMethodList(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        List publicMethods = new ArrayList();
        for (int i = 0; i < methods.length; i++) {
            addIfPublic(methods[i], publicMethods);
        }
        return publicMethods;
    }

    private void addIfPublic(Method method, List publicMethods) {
        if (isPublic(method)) {
            publicMethods.add(method);
        }
    }

    private boolean isPublic(Method method) {
        int modifiers = method.getModifiers();
        return Modifier.isPublic(modifiers);
    }

    private Method doGetMethod(boolean exact, Class cls, MethodSpec targetMethod) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methodsMatch(exact, methods[i], targetMethod)) return methods[i];
        }
        throw new NoSuchMethodError(targetMethod.toString());
    }

    private boolean methodsMatch(boolean exact, Method sourceMethod, MethodSpec targetMethod) {
        String name = targetMethod.getName();
        if (!methodNamesMatch(sourceMethod, name)) return false;
        Class[] params = targetMethod.getParams();
        return paramsMatch(exact, sourceMethod, params);
    }

    private boolean methodNamesMatch(Method sourceMethod, String targetMethodName) {
        String methodName = sourceMethod.getName();
        return methodName.equals(targetMethodName);
    }

    private boolean paramsMatch(boolean exact, Method sourceMethod, Class[] parameterTypes) {
        Class[] params = sourceMethod.getParameterTypes();
        if (parameterTypes.length != params.length) {
            return false;
        }
        for (int i = 0; i < params.length; i++) {
            if (!paramMatches(exact, params[i], parameterTypes[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean paramMatches(boolean exact, Class sourceParam, Class targetParam) {
        if (isWrapperOf(targetParam, sourceParam)) return true;
        if (exact) return sourceParam == targetParam;
        return sourceParam.isAssignableFrom(targetParam);
    }

    // OK NCSS|CyclomaticComplexity|ReturnCount {
    private boolean isWrapperOf(Class wrapper, Class primitive) {
        if (primitive == boolean.class && wrapper == Boolean.class) return true;
        if (primitive == short.class && wrapper == Short.class) return true;
        if (primitive == int.class && wrapper == Integer.class) return true;
        if (primitive == long.class && wrapper == Long.class) return true;
        if (primitive == double.class && wrapper == Double.class) return true;
        return primitive == float.class && wrapper == Float.class;
    }
    // } OK NCSS|CyclomaticComplexity|ReturnCount

    private void checkNotNull(Object param) {
        if (param == null) {
            throw new IllegalArgumentException();
        }
    }
}
