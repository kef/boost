package au.net.netstorm.boost.test.automock;

// FIX (Dec 5, 2007) IOC 85875 Merge with MockExpectationsEngine.
public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName, Object... parameters);

    void oneCall(Object ref, Throwable throwable, String methodName, Object... params);

    void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters);

    // FIX (Dec 5, 2007) IOC 85875 MOve the nu on the TestCase maybe?
    void nu(Object ref, Object returnValue, Class impl, Object... params);
}
