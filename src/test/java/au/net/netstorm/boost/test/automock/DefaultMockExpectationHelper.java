package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.builder.MatchBuilder;
import org.jmock.builder.NameMatchBuilder;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;
import org.jmock.core.constraint.IsSame;

final class DefaultMockExpectationHelper implements MockExpectationHelper {
    private final AutoMocker autoMocker;
    private final MockObjectTestCase jMock;

    public DefaultMockExpectationHelper(AutoMocker autoMocker, MockObjectTestCase jMock) {
        this.autoMocker = autoMocker;
        this.jMock = jMock;
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        MatchBuilder builder = getMethod(ref, methodName).with(same(parameters));
        if (returnValue == null) barf();
        if (returnValue == UsesMocks.VOID) return;
        builder.will(returnValue(returnValue));
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters) {
        MatchBuilder builder = getMethod(ref, methodName).with(same(parameters));
        builder.will(throwException(throwable));
    }

    private IsSame[] same(Object[] parameters) {
        int length = parameters.length;
        IsSame[] result = new IsSame[length];
        for (int i = 0; i < length; i++) result[i] = same(parameters[i]);
        return result;
    }

    private ArgumentsMatchBuilder getMethod(Object ref, String methodName) {
        Mock mock = getMock(ref);
        // FIX SC525 Why don't we have to call stubs()?
        NameMatchBuilder builder = mock.expects(once());
        return builder.method(methodName);
    }

    private Stub throwException(Throwable throwable) {
        return jMock.throwException(throwable);
    }

    private void barf() {
        throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
    }

    private Mock getMock(Object ref) {
        return autoMocker.getMock(ref);
    }

    private InvocationMatcher once() {
        return jMock.once();
    }

    private Stub returnValue(Object ref) {
        return jMock.returnValue(ref);
    }

    private IsSame same(Object ref) {
        return jMock.same(ref);
    }
}