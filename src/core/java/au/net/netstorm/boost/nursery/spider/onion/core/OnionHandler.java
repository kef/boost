package au.net.netstorm.boost.nursery.spider.onion.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class OnionHandler implements InvocationHandler {
    // FIX 1887 Move the peeler setup out of here into place where it is done once.
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Method core = classer.getMethod(OnionSkin.class, "core", new Class[]{});
    private final Object real;

    public OnionHandler(Object real) {
        this.real = real;
    }

    // FIX 1887 Complete this.
    public Object invoke(Object ref, Method method, Object[] params) throws Throwable {
        // FIX 1887 Follow up the suggest.
        // SUGGEST: Move peeler check below call.  Ie assume not, catch exception then process peel.  Only if slow.
        if (method.equals(core)) return real;
        method.setAccessible(true);
        return method.invoke(real, params);
    }
}