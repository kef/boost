package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;

public interface MockProvider {
    Mock mock(Class mockType);
    Mock mock(Class mockType, String role);
}
