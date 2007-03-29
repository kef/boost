package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
public interface MockExpectations {
    void oneCall(Object ref, Object returnValue, String methodName);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4);

    void oneCall(Object ref, Throwable throwable, String methodName);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4);

    void manyCalls(Object ref, Object returnValue, String methodName);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3);

    void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4);

    void oneCall(Object ref, Object returnValue, String methodName, Object[] parameters);

    void canCall(Object ref, Object returnValue, String methodName, Object[] parameters);
}
// } OK ParameterNumber|LineLength - We are providing flattened array support ... like jMock.
