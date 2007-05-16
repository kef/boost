package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.automock.UsesMocks;

public interface MockInjector {
    void inject(UsesMocks test, Object subject, String fieldName);
}
