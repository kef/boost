package au.net.netstorm.boost.sniper.automock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.jmock.Mock;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

public final class DefaultMockSupport implements MockSupport {
    private final MyMockObjectTestCase delegate = new MyMockObjectTestCase();
    private final Map mocks = new HashMap();
    private final Random random = new Random();

    public Object mock(Class mockedType) {
        Mock mock = delegate.mock(mockedType);
        return proxyAndRecord(mock);
    }

    public Object mock(Class mockedType, String roleName) {
        String randomName = roleName + "(" + random() + ")";
        Mock mock = delegate.mock(mockedType, randomName);
        return proxyAndRecord(mock);
    }

    public Object dummy(Class dummyType, String name) {
        return delegate.newDummy(dummyType, name);
    }

    public Mock mockForProxy(Object proxy) {
        Mock mock = (Mock) mocks.get(proxy);
        if (mock != null) return mock;
        throw new IllegalStateException("No mock exists for " + proxy);
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

    private int random() {
        return random.nextInt();
    }

    private Object proxyAndRecord(Mock mock) {
        Object proxy = mock.proxy();
        mocks.put(proxy, mock);
        return proxy;
    }

    // Don't want to expose subclass.
    private class MyMockObjectTestCase extends org.jmock.MockObjectTestCase {
    }
}
