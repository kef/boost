package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;
import org.jmock.builder.ArgumentsMatchBuilder;
import org.jmock.builder.MatchBuilder;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;
import org.jmock.core.constraint.IsSame;

// FIX SC525 Split into two classes.  The first is a facade.  The second the guts.
// FIX SC525 Remove trainwrecks.
// OK ParameterNumber|LineLength {
public final class DefaultMockExpectations implements MockExpectations {
    private final AutoMocker autoMocker;
    private final MockObjectTestCase jMock;

    public DefaultMockExpectations(AutoMocker autoMocker, MockObjectTestCase jMock) {
        this.autoMocker = autoMocker;
        this.jMock = jMock;
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter0) {
        Object[] parameters = {parameter0};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2) {
        Object[] parameters = {parameter1, parameter2};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3) {
        Object[] parameters = {parameter1, parameter2, parameter3};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        Object[] parameters = {parameter1,parameter2,parameter3,parameter4};
        oneCall(ref, methodName, returnValue, parameters);
    }

    public void oneCall(Object ref, String methodName, Object returnValue, Object[] parameters) {
        MatchBuilder builder = getMethod(ref, methodName).with(same(parameters));
        if (returnValue == null)
            throw new IllegalStateException("If your method returns void, pass in the void marker in the test interface.");
        if (returnValue == UsesMocks.VOID) return;
        builder.will(returnValue(returnValue));
    }

    // FIX SC525 Needs parameters.
    public void oneCall(Object ref, String methodName, Throwable throwable, Object param0) {
        Object[] parameters = {param0};
        oneCall(ref, methodName, throwable, parameters);
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2) {
        // FIX SC525 Finish these.
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3) {
        throw new UnsupportedOperationException();
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        throw new UnsupportedOperationException();
    }

    public void oneCall(Object ref, String methodName, Throwable throwable, Object[] parameters) {
        getMethod(ref, methodName).with(same(parameters))
                .will(throwException(throwable));
    }

    private IsSame[] same(Object[] parameters) {
        int length = parameters.length;
        IsSame[] result = new IsSame[length];
        for (int i = 0; i < length; i++) result[i] = same(parameters[i]);
        return result;
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
// } OK ParameterNumber|LineLength - See interface.