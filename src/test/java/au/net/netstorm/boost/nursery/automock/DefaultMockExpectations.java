package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.MatchBuilder;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.core.Stub;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.constraint.IsSame;

// FIX SC525 Split into two classes.  The first is a facade.  The second the guts.
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

    // FIX SC525 Needs parameters.
    public void oneCall(Object ref, String methodName, Throwable throwable, Object param0) {
        getMethod(ref, methodName).with(same(param0)).will(throwException(throwable));
    }

    private void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        Mock mock = getMock(ref);
        // FIX SC525 This only works for one parameter.
        MatchBuilder builder = getMethod(ref, methodName).with(same(parameters[0]));
        // FIX SC525 Tidy this message up.
        if (returnValue == null) throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
        if (returnValue == UsesMocks.VOID) return;
        builder.will(returnValue(returnValue));

    }

    private ArgumentsMatchBuilder getMethod(Object ref, String methodName) {
        Mock mock = getMock(ref);
        return mock.expects(once()).method(methodName);
    }

    private Stub throwException(Throwable throwable) {
        return jMock.throwException(throwable);
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
