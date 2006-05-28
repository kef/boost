package au.net.netstorm.boost.test.primordial;

import org.jmock.Mock;

public interface MockProvider {
    Mock mock(Class mockType);

    Mock mock(Class mockType, String role);
}
