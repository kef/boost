package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultMockMethodSpec extends Primordial implements MockMethodSpec {
    private Object returnValue;
    private String methodName;
    private Object[] parameters;

    public DefaultMockMethodSpec(Object returnValue, String methodName, Object[] parameters) {
        this.returnValue = returnValue;
        this.methodName = methodName;
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
