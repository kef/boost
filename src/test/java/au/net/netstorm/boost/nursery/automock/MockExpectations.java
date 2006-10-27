package au.net.netstorm.boost.nursery.automock;

// OK ParameterNumber {
public interface MockExpectations {
    // FIX SC525 Make naming consistent.
    // FIX SC525 Support up to 4 parameters inline.
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1);
    void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2);
    void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1);
    // FIX SC525 Delete or incorporate.
//    void call(Object ref, String method, Object returnValue, Object param0, Object param1);
//    void call(Object ref, String method, Object returnValue, Object param0, Object param1, Object param2);
}
// } OK ParameterNumber - We are providing flattened array support ... like jMock.
