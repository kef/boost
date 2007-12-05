package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.primordial.Primordial;

final class DefaultMockMethodSpec extends Primordial implements MockMethodSpec {
    private Object returnValue;
    private String methodName;
    private Object[] parameters;

    public DefaultMockMethodSpec(Object returnValue, String methodName, Object[] parameters) {
        this.returnValue = returnValue;
        this.methodName = methodName;
        this.parameters = parameters.clone();
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParameters() {
        return parameters.clone();
    }
}
