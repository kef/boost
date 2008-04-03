package au.net.netstorm.boost.gunge.automock;

import org.jmock.Mock;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.builder.MatchBuilder;
import org.jmock.builder.NameMatchBuilder;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

final class DefaultMockExpectationEngine implements MockExpectationEngine {
    private static final Object VOID = MockExpectations.VOID;
    private final MockSupport mocks;

    public DefaultMockExpectationEngine(MockSupport mocks) {
        this.mocks = mocks;
    }

    public void oneCall(Object ref, MockMethodSpec spec) {
        calls(ref, one(), spec);
    }

    public void manyCalls(Object ref, MockMethodSpec spec) {
        calls(ref, many(), spec);
    }

    public void oneCall(Object ref, Throwable throwable, String methodName, Object[] parameters) {
        checkNotNull(throwable);
        MatchBuilder builder = getMethod(ref, methodName, parameters, one());
        builder.will(throwException(throwable));
    }

    private void calls(Object ref, InvocationMatcher matcher, MockMethodSpec spec) {
        String methodName = spec.getMethodName();
        Object[] parameters = spec.getParameters();
        MatchBuilder builder = getMethod(ref, methodName, parameters, matcher);
        buildReturn(spec, builder);
    }

    private void buildReturn(MockMethodSpec spec, MatchBuilder builder) {
        Object returnValue = spec.getReturnValue();
        if (VOID == returnValue) return;
        builder.will(returnValue(returnValue));
    }

    private Constraint[] same(Object[] parameters) {
        int length = parameters.length;
        Constraint[] result = new Constraint[length];
        for (int i = 0; i < length; i++) result[i] = eq(parameters[i]);
        return result;
    }

    private MatchBuilder getMethod(Object ref, String methodName, Object[] parameters, InvocationMatcher matcher) {
        Mock mock = getMock(ref);
        NameMatchBuilder builder = mock.expects(matcher);
        ArgumentsMatchBuilder matchBuilder = builder.method(methodName);
        return matchBuilder.with(same(parameters));
    }

    private void barf() {
        throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
    }

    private Mock getMock(Object ref) {
        return mocks.mockForProxy(ref);
    }

    private Stub throwException(Throwable throwable) {
        return mocks.throwException(throwable);
    }

    private InvocationMatcher one() {
        return mocks.once();
    }

    private InvocationMatcher many() {
        return mocks.atLeastOnce();
    }

    private Stub returnValue(Object ref) {
        return mocks.returnValue(ref);
    }

    private Constraint eq(Object ref) {
        return mocks.eq(ref);
    }

    private void checkNotNull(Object ref) {
        if (ref == null) barf();
    }
}