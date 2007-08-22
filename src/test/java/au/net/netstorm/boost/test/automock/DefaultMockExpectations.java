package au.net.netstorm.boost.test.automock;

// OK ParameterNumber|LineLength {
public final class DefaultMockExpectations implements MockExpectations {
    private MockExpectationEngine delegate;

    public DefaultMockExpectations(MockSupport mocks) {
        delegate = new DefaultMockExpectationEngine(mocks);
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

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7};
        oneCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5};
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6};
        oneCall(ref, throwable, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7};
        oneCall(ref, throwable, methodName, parameters);
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

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object parameter1, Object parameter2, Object parameter3, Object parameter4, Object parameter5, Object parameter6, Object parameter7) {
        Object[] parameters = {parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7};
        canCall(ref, returnValue, methodName, parameters);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName) {
        Object[] parameters = {};
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
