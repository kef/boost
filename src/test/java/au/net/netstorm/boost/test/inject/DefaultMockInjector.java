package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultMockInjector implements MockInjector {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void inject(BoooostCase test, Object subject, String fieldName) {
        inject(test, subject, fieldName, fieldName);
    }

    // FIX 2076 Test me
    public void inject(BoooostCase test, Object subject, String testFieldName, String subjectFieldName) {
        Object value = fielder.getInstance(test, testFieldName);
        fielder.setInstance(subject, subjectFieldName, value);
    }
}
