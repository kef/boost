package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

public final class DefaultMockObjectTestCase implements MockObjectTestCase {
    private final MyMockObjectTestCase delegate = new MyMockObjectTestCase();

    public Mock mock(Class mockedType) {
        return delegate.mock(mockedType);
    }

    public Mock mock(Class mockedType, String roleName) {
        return delegate.mock(mockedType, roleName);
    }

    public Stub returnValue(Object o) {
        return delegate.returnValue(o);
    }

    public Stub throwException(Throwable throwable) {
        return delegate.throwException(throwable);
    }

    public InvocationMatcher once() {
        return delegate.once();
    }

    public InvocationMatcher atLeastOnce() {
        return delegate.atLeastOnce();
    }

    public InvocationMatcher atMostOnce() {
        return delegate.atMostOnce();
    }

    public InvocationMatcher exactly(int expectedCount) {
        return delegate.exactly(expectedCount);
    }

    public InvocationMatcher never() {
        return delegate.never();
    }

    public InvocationMatcher never(String errorMessage) {
        return delegate.never(errorMessage);
    }

    public void verify() {
        delegate.verify();
    }

    public Constraint eq(Object ref) {
        return delegate.eq(ref);
    }

    public Object newDummy(Class dummyType, String name) {
        return delegate.newDummy(dummyType, name);
    }

    // Don't want to expose subclass.
    private class MyMockObjectTestCase extends org.jmock.MockObjectTestCase {
    }
}
