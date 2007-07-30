package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;

public interface MockProvider {
    Mock mock(Class mockType);

    Mock mock(Class mockType, String role);

    Object dummy(Class dummyType, String name);
}
