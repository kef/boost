package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.MatchBuilder;
import org.jmock.core.Stub;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.constraint.IsSame;

public final class DefaultMockExpectations implements MockExpectations {
    private final AutoMocker autoMocker;
    private final MockObjectTestCase jMock;

    public DefaultMockExpectations(AutoMocker autoMocker, MockObjectTestCase jMock) {
        this.autoMocker = autoMocker;
        this.jMock = jMock;
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object param0) {
        Object[] parameters = { param0 };
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void throwsException(Object ref, String methodName, Throwable throwable) {
        // FIX SC525 Breadcrumb.
    }

    private void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        Mock mock = autoMocker.getMock(ref);
        // FIX SC525 This only works for one parameter.
        MatchBuilder builder = mock.expects(once()).method(methodName).with(same(parameters[0]));
        // FIX SC525 Tidy this message up.
        if (returnValue == null) throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
        if (returnValue == UsesMocks.VOID) return;
        builder.will(returnValue(returnValue));

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
