package au.net.netstorm.boost.test.automock;

interface MockExpectationHelper {
    void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters);
    void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters);
}
