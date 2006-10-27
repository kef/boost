package au.net.netstorm.boost.nursery.automock;

// OK ParameterNumber {
public interface MockExpectations {
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
    void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
    void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters);
}
// } OK ParameterNumber - We are providing flattened array support ... like jMock.
