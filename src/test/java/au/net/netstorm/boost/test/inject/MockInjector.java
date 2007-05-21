package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.cases.BoooostCase;

public interface MockInjector {
    void inject(BoooostCase test, Object subject, String fieldName);
}
