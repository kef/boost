package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
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

    public void call(Object ref, String method, Object returnValue, Object param0) {
        // FIX SC525 How to handle void return.
        Mock mock = autoMocker.getMock(ref);
        mock.expects(once()).method(method).with(same(param0)).will(returnValue(returnValue));
    }

    public void call(Object ref, String method, Object param0) {
        Mock mock = autoMocker.getMock(ref);
        mock.expects(once()).method(method).with(same(param0));
    }

    public void exception(Object ref, String method, Exception exception) {
        Mock mock = autoMocker.getMock(ref);
        mock.expects(once()).method(method).will(throwException(exception));
    }

    private Stub throwException(Exception exception) {
        return jMock.throwException(exception);
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
