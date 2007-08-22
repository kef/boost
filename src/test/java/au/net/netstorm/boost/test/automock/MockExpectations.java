package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
public interface MockExpectations {
    Object VOID = "void";

    void oneCall(Object ref, Object returnValue, String methodName);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7);

    void oneCall(Object ref, Throwable throwable, String methodName);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7);

    void manyCalls(Object ref, Object returnValue, String methodName);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7);
}
// } OK ParameterNumber|LineLength - We are providing flattened array support ... like jMock.
