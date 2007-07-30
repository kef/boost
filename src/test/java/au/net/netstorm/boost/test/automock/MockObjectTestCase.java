package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;

public interface MockObjectTestCase {
    Mock mock(Class mockedType);

    Mock mock(Class mockedType, String roleName);

    Stub returnValue(Object o);

    Stub throwException(Throwable throwable);

    InvocationMatcher once();

    InvocationMatcher atLeastOnce();

    InvocationMatcher atMostOnce();

    InvocationMatcher exactly(int expectedCount);

    InvocationMatcher never();

    InvocationMatcher never(String errorMessage);

    void verify();

    Constraint eq(Object ref);

    Object newDummy(Class dummyType, String name);
}
