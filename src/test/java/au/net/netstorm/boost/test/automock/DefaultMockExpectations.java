package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
final class DefaultMockExpectations implements MockExpectations {
    private MockExpectationEngine delegate;

    public DefaultMockExpectations(MockExpectationEngine delegate) {
        this.delegate = delegate;
    }

    public void oneCall(Object ref, String methodName, Object returnValue) {
        Object[] parameters = {};
        oneCall(ref, methodName, returnValue, parameters);
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
        Object[] parameters = { };
        oneCall(ref, methodName, throwable, parameters);
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

    private void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        delegate.oneCall(ref, returnValue, methodName, parameters);
    }

    private void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters) {
        delegate.oneCall(ref, methodName, throwable, parameters);
    }
}
// } OK ParameterNumber|LineLength - See interface.
