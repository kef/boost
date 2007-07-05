package au.net.netstorm.boost.test.random;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Invocation {

    private final Object invoked;
    private final Method method;
    private final Object[] params;

    public Invocation(Object object, Method method, Object[] params) {
        this.invoked = object;
        this.method = method;
        this.params = params;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        return checkFieldsSame(o);
    }

    private boolean checkFieldsSame(Object o) {
        Invocation that = (Invocation) o;
        if (!methodsEqual(that)) return false;
        if (!paramsEqual(that)) return false;
        return true;
    }

    private boolean paramsEqual(Invocation that) {
        return Arrays.equals(params, that.params);
    }

    private boolean methodsEqual(Invocation that) {
        return method.equals(that.method);
    }

    public int hashCode() {
        int methodHashCode = method.hashCode();
        int paramsHashCode = arrayHashCode(params);
        return 31 * methodHashCode + paramsHashCode;
    }

    private int arrayHashCode(Object[] params) {
        if (params == null) return 0;
        int hashCode = 0;
        for (int i = 0; i < params.length; i++) {
            hashCode += params[i].hashCode();
        }
        return hashCode;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getParams() {
        return params;
    }

    public Object getInvoked() {
        return invoked;
    }
}
