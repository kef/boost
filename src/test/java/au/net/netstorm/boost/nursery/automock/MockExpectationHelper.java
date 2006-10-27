package au.net.netstorm.boost.nursery.automock;

// FIX SC525 Narrow scope.
interface MockExpectationHelper {
    void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters);
    void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters);
}
