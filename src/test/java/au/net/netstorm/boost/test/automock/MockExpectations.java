package au.net.netstorm.boost.test.automock;

public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName, Object... parameters);

    void oneCall(Object ref, Throwable throwable, String methodName, Object... params);

    void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters);

    void nu(Object ref, Object returnValue, Class impl, Object... params);
}
