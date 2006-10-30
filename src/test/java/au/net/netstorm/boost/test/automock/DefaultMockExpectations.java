package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
final class DefaultMockExpectations implements MockExpectations {
    private MockExpectationHelper delegate;

    public DefaultMockExpectations(MockExpectationHelper delegate) {
        this.delegate = delegate;
    }

    // FIX SC525 Support no parameters.
    public void oneCall(Object ref, String methodName, Object returnValue) {
        // FIX SC525 Complete.
        throw new UnsupportedOperationException();
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1) {
        Object[] parameters = {parameter1};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable) {
        // FIX SC525 Complete.
        throw new UnsupportedOperationException();
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1) {
        Object[] parameters = {parameter1};
        oneCall(ref, methodName, throwable, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        oneCall(ref, methodName, throwable, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        oneCall(ref, methodName, throwable, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4};
        oneCall(ref, methodName, throwable, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        delegate.oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters) {
        delegate.oneCall(ref, methodName, throwable, parameters);
    }
}
// } OK ParameterNumber|LineLength - See interface.
