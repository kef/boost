package au.net.netstorm.boost.splitter;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

final class MockListener extends Assert implements InvocationHandler {
    private final Interface type;
    private final Map calls = new HashMap();
    private String methodName;
    private Object[] parameters;
    private Throwable throwable;

    public MockListener(Interface type) {
        this.type = type;
    }

    public Object invoke(Object object, Method method, Object[] parameters) throws Throwable {
        if (throwable != null) {
            throw throwable;
        }
        String name = method.getName();
        checkCall(method, getParameters(parameters));
        incrementCallCount(name);
        return null;
    }

    public void setExpectation(String methodName, Object[] parameters) {
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public void checkCallCount(String methodName, int expectedCount) {
        Integer count = (Integer) calls.get(methodName);
        assertNotNull("No call made to method \"" + methodName + "\"", count);
        assertEquals(expectedCount, count.intValue());
    }

    public Object getRef() {
        ClassLoader loader = type.getClass()
                .getClassLoader();
        Class[] types = {type.getType()};
        return Proxy.newProxyInstance(loader, types, this);
    }

    private void checkCall(Method method, Object[] parameters) {
        assertEquals(methodName, method.getName());
        assertEquals(parameters.length, parameters.length);
        for (int i = 0; i < parameters.length; i++) {
            assertEquals(this.parameters[i], parameters[i]);
        }
    }

    /**
     * See j.l.r.InvocationHandler.
     */
    private Object[] getParameters(Object[] parameters) {
        if (parameters != null) {
            return parameters;
        }
        return new Object[]{};
    }

    private void incrementCallCount(String name) {
        Integer count = (Integer) calls.get(name);
        count = (count == null) ? new Integer(0) : count;
        count = new Integer(count.intValue() + 1);
        calls.put(name, count);
    }
}
