package au.net.netstorm.boost.gunge.automock;

public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName, Object... parameters);

    void oneCall(Object ref, Throwable throwable, String methodName, Object... parameters);

    void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters);
}
