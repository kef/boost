package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.builder.MatchBuilder;
import org.jmock.builder.NameMatchBuilder;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

final class DefaultMockExpectationHelper implements MockExpectationHelper {
    private static final Object VOID = UsesMocks.VOID;
    private static final Object NULL = UsesMocks.NULL;
    private final AutoMocker autoMocker;
    private final MockObjectTestCase jMock;

    public DefaultMockExpectationHelper(AutoMocker autoMocker, MockObjectTestCase jMock) {
        this.autoMocker = autoMocker;
        this.jMock = jMock;
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        MatchBuilder builder = getMethod(ref, methodName, parameters);
        checkNotNull(returnValue);
        if (returnValue == VOID) return;
        Object value = (returnValue == NULL) ? null : returnValue;
        builder.will(returnValue(value));
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters) {
        checkNotNull(throwable);
        MatchBuilder builder = getMethod(ref, methodName, parameters);
        builder.will(throwException(throwable));
    }

    private Constraint[] same(Object[] parameters) {
        int length = parameters.length;
        Constraint[] result = new Constraint[length];
        for (int i = 0; i < length; i++) result[i] = eq(parameters[i]);
        return result;
    }

    private MatchBuilder getMethod(Object ref, String methodName, Object[] parameters) {
        Mock mock = getMock(ref);
        NameMatchBuilder builder = mock.expects(once());
        ArgumentsMatchBuilder matchBuilder = builder.method(methodName);
        return matchBuilder.with(same(parameters));
    }

    private void barf() {
        throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
    }

    private Mock getMock(Object ref) {
        return autoMocker.getMock(ref);
    }

    private Stub throwException(Throwable throwable) {
        return jMock.throwException(throwable);
    }

    private InvocationMatcher once() {
        return jMock.once();
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