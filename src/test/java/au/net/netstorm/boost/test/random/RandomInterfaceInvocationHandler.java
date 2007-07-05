package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

final class RandomInterfaceInvocationHandler implements InvocationHandler {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Map priorCalls = new HashMap();
    private final Class proxiedType;
    private final RandomProvider random;
    private final SpecificProviderRegistry specific;

    public RandomInterfaceInvocationHandler(Class proxiedType, RandomProvider randomProvider, SpecificProviderRegistry specificProviders) {
        this.proxiedType = proxiedType;
        this.random = randomProvider;
        this.specific = specificProviders;
    }

    public Object invoke(Object ref, Method method, Object[] params) throws Throwable {
        Invocation invocation = new Invocation(method, params);
        return invoke(ref, invocation);
    }

    private Object invoke(Object ref, Invocation invocation) {
        if (priorCalls.containsKey(invocation)) return priorCalls.get(invocation);
        Object result = provide(ref, invocation);
        priorCalls.put(invocation, result);
        return result;
    }

    private Object provide(Object ref, Invocation invocation) {
        Method method = invocation.getMethod();
        Object[] params = invocation.getParams();
        if (isEquals(method)) return doEquals(ref, params[0]);
        if (isToString(method)) return doToString();
        return provide(method);
    }

    private Object provide(Method method) {
        Class type = method.getReturnType();
        boolean specific = this.specific.contains(type);
        return specific ? this.specific.get(type) : random.get(type);
    }

    private boolean isToString(Method method) {
        return same(method, "toString", new Class[]{});
    }

    private boolean isEquals(Method method) {
        return same(method, "equals", new Class[]{Object.class});
    }

    private Object doEquals(Object o1, Object o2) {
        return Boolean.valueOf(o1 == o2);
    }

    private Object doToString() {
        Object niceShortRandom = random.get(Integer.class);
        return "Dummy proxy for <" + proxiedType + " (" + niceShortRandom + ")>";
    }

    private boolean same(Method method, String methodName, Class[] parameterTypes) {
        Method toString = classer.getMethod(Object.class, methodName, parameterTypes);
        return method.equals(toString);
    }
}
