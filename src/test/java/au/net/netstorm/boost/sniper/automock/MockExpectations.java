package au.net.netstorm.boost.sniper.automock;

public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName, Object... parameters);

    void oneCall(Object ref, Throwable throwable, String methodName, Object... parameters);

    // FIX 2394 why is this "one or more" rather than "more than one"
    void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters);
}
