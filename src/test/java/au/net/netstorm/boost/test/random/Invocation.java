package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

import java.lang.reflect.Method;

public class Invocation extends Primordial implements Data {
    private final Method method;
    private final Object[] params;

    public Invocation(Method method, Object[] params) {
        this.method = method;
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getParams() {
        return params;
    }
}