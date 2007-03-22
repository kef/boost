package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.builder.MatchBuilder;
import org.jmock.builder.NameMatchBuilder;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

final class DefaultMockExpectationEngine implements MockExpectationEngine {
    private static final Object VOID = UsesMocks.VOID;
    private final AutoMocker autoMocker;
    private final MockObjectTestCase jMock;

    public DefaultMockExpectationEngine(AutoMocker autoMocker, MockObjectTestCase jMock) {
        this.autoMocker = autoMocker;
        this.jMock = jMock;
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
        return autoMocker.mock(ref);
    }

    private Stub throwException(Throwable throwable) {
        return jMock.throwException(throwable);
    }

    private InvocationMatcher one() {
        return jMock.once();
    }

    private InvocationMatcher many() {
        return jMock.atLeastOnce();
    }

    private Stub returnValue(Object ref) {
        return jMock.returnValue(ref);
    }

    private Constraint eq(Object ref) {
        return jMock.eq(ref);
    }

    private void checkNotNull(Object ref) {
        if (ref == null) barf();
    }
}