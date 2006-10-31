package au.net.netstorm.boost.test.automock;

interface MockExpectationEngine {
    void oneCall(Object ref, Object returnValue, String methodName, Object[] parameters);
    void oneCall(Object ref, Throwable throwable, String methodName, Object[] parameters);
}
