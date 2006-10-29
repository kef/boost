package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
// FIX SC525 How about canCall()?
// FIX SC525 mayCall().
// FIX SC525 Adding primitive mocks on demand.  Sort out some sort of autoboxing.  Maybe this is the answer.
public interface MockExpectations extends MockExpectationHelper {
    // FIX SC525 Support no parameters.
    // FIX SC525 Damn primitive types.
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1);
    void oneCall(Object ref, String methodName, Object returnValue, Object pNarameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3, Object parameter4);
}
// } OK ParameterNumber|LineLength - We are providing flattened array support ... like jMock.
