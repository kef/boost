package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
// FIX SC525 How about canCall() / mayCall()?
public interface MockExpectations extends MockExpectationHelper {
    // FIX SC525 Support no parameters.
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
}
// } OK ParameterNumber|LineLength - We are providing flattened array support ... like jMock.
