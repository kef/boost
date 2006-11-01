package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

// FIX 525 Extract interface.
public final class DefaultMethodSignature extends Primordial implements Data {
    private Object returnValue;
    private String methodName;
    private Object[] parameters;

    public DefaultMethodSignature(Object returnValue, String methodName, Object[] parameters) {
        this.returnValue = returnValue;
        this.methodName = methodName;
        // FIX 525 Remove the need to clone.  We are mutable right?  ??????
        this.parameters = (Object[]) parameters.clone();
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParameters() {
        return (Object[]) parameters.clone();
    }
}
