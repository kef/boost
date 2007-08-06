package au.net.netstorm.boost.nursery.spider.onion.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class OnionHandler implements InvocationHandler {
    //    private final EdgeClass classer = new DefaultEdgeClass();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Method peel = classer.getMethod(OnionSkin.class, "real", new Class[]{});
    private final Object real;

    public OnionHandler(Object real) {
        this.real = real;
    }

    // FIX 1887 Complete this.
    public Object invoke(Object ref, Method method, Object[] params) throws Throwable {
        if (method.equals(peel)) return real;
        method.setAccessible(true);
        return method.invoke(real, params);
    }

    // FIX 1887 Remove.
/*
    // FIX BREADCRUMB 1887 This would be a good cache point.
    private Method realMethod(Method ifaceMethod, Object[] params) {
        Class cls = real.getClass();
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (matches(method, ifaceMethod)) return method;
        }
        throw new IllegalStateException("No matching method " + ifaceMethod + " on " + cls);
    }

    private boolean matches(Method method, Method ifaceMethod) {
        if (!nameMatches(method, ifaceMethod)) return false;
        Class[] sig = method.getParameterTypes();
        Class[] ifaceSig = ifaceMethod.getParameterTypes();
        if (sig.length != ifaceSig.length) return false;
        for (int i = 0; i < sig.length; i++) {
            Class type = sig[i];
            Class ifaceType = ifaceSig[i];
            if (!ifaceType.isAssignableFrom(type)) return false;
        }
        return true;
    }

    private boolean nameMatches(Method method, Method ifaceMethod) {
        String name = method.getName();
        String ifaceName = ifaceMethod.getName();
        if (!name.equals(ifaceName)) return false;
        return true;
    }
*/
}
