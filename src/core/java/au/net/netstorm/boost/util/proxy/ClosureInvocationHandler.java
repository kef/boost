package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.spider.onion.core.Closure;

import java.lang.reflect.InvocationHandler;

// FIX 2248 TDD.
final class ClosureInvocationHandler extends Primordial implements InvocationHandler {
    private final Closure closure;

    public ClosureInvocationHandler(Closure closure) {
        this.closure = closure;
    }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
        Method edgeMethod = new DefaultMethod(method);
        return closure.invoke(edgeMethod, args);
    }
}
