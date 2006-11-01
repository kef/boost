package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
final class DefaultMockExpectations implements MockExpectations {
    private MockExpectationEngine delegate;

    // Make sure to follow the pattern here and keep things consistent.

    public DefaultMockExpectations(MockExpectationEngine delegate) {
        this.delegate = delegate;
    }

    public void oneCall(Object ref, Object returnValue, String methodName) {
        Object[] parameters = {};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1) {
        Object[] parameters = {parameter1};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName) {
        Object[] parameters = {};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1) {
        Object[] parameters = {parameter1};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName) {
        Object[] parameters = { };
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1) {
        Object[] parameters = {parameter1};
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4};
        oneCall(ref, throwable, methodName, parameters);
    }

    // Delegates...

    private void oneCall(Object ref, Object returnValue, String methodName, Object[] parameters) {
        MockMethodSpec spec = new DefaultMockMethodSpec(returnValue, methodName, parameters);
        delegate.oneCall(ref, spec);
    }

    private void canCall(Object ref, Object returnValue, String methodName, Object[] parameters) {
        MockMethodSpec spec = new DefaultMockMethodSpec(returnValue, methodName, parameters);
        delegate.manyCalls(ref, spec);
    }

    private void oneCall(Object ref, Throwable throwable, String methodName, Object[] parameters) {
        delegate.oneCall(ref, throwable, methodName, parameters);
    }

}
// } OK ParameterNumber|LineLength - See interface.
