package au.net.netstorm.boost.test.automock;

// FIX (Dec 5, 2007) IOC 88878 Merge with MockExpectationsEngine.
public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName, Object... parameters);

    void oneCall(Object ref, Throwable throwable, String methodName, Object... parameters);

    void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters);
}
