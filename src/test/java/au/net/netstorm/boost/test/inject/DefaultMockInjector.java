package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultMockInjector implements MockInjector {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void inject(UsesMocks test, Object subject, String fieldName) {
        Object value = fielder.getInstance(test, fieldName);
        fielder.setInstance(subject, fieldName, value);
    }
}
