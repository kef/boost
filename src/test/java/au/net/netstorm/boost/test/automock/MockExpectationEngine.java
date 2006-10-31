package au.net.netstorm.boost.test.automock;

interface MockExpectationEngine {
    void oneCall(Object ref, Object returnValue, String methodName, Object[] parameters);
    void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters);
}
