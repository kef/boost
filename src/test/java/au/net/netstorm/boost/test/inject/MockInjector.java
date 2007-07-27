package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.core.BoooostCase;

public interface MockInjector {
    void inject(BoooostCase test, Object subject, String fieldName);

    void inject(BoooostCase testCase, Object subject, String testCaseFieldName, String subjectFieldName);
}
