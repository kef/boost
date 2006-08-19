package au.net.netstorm.boost.test.atom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class NoOpInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
