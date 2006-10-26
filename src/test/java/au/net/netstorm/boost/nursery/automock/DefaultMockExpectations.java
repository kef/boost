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

    public void oneCall(Object ref, String method, Object returnValue, Object param0) {
        // FIX SC525 Bundle up parameters and pass in to method(class?) as array.
        // FIX SC525 How to handle void return.
        Mock mock = autoMocker.getMock(ref);
        MatchBuilder builder = mock.expects(once()).method(method).with(same(param0));
        // FIX SC525 Tidy this message up.
        if (returnValue == null) throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
        if (returnValue == UsesMocks.VOID) return;
        builder.will(returnValue(returnValue));
    }

    public void throwsException(Object ref, String methodName, Throwable throwable) {
        // FIX SC525 Breadcrumb.
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
