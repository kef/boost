package au.net.netstorm.boost.gunge.automock;

public final class DefaultMockExpectations implements MockExpectations {
    private MockExpectationEngine delegate;

    public DefaultMockExpectations(MockSupport mocks) {
        delegate = new DefaultMockExpectationEngine(mocks);
    }

    public void oneCall(Object ref, Object returnValue, String methodName, Object... parameters) {
        MockMethodSpec spec = new DefaultMockMethodSpec(returnValue, methodName, parameters);
        delegate.oneCall(ref, spec);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object... params) {
        delegate.oneCall(ref, throwable, methodName, params);
    }

    public void manyCalls(Object ref, Object returnValue, String methodName, Object... parameters) {
        MockMethodSpec spec = new DefaultMockMethodSpec(returnValue, methodName, parameters);
        delegate.manyCalls(ref, spec);
    }
}
