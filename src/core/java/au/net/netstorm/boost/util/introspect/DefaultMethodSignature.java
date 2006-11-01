package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 525 Extract interface.
public final class DefaultMethodSignature extends Primordial implements Data {
    private Object returnValue;
    private String methodName;

    public DefaultMethodSignature(Object returnValue, String methodName) {
        this.returnValue = returnValue;
        this.methodName = methodName;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public String getMethodName() {
        return methodName;
    }
}
