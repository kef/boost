package au.net.netstorm.boost.test.automock;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.Mock;

// SUGGEST Make sure no production code (core, edge or test) is using the nursery, outside of the nursery of course.
public class DefaultAutoMocker implements AutoMocker {
    private static final String MSG = "Mock does not exist for provided proxy.  Make sure to implement ";
    private final Map mocks = new HashMap();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockProvider mockProvider;

    public DefaultAutoMocker(MockProvider mockProvider) {
        this.mockProvider = mockProvider;
    }

    public Mock get(Object proxy) {
        Mock mock = (Mock) mocks.get(proxy);
        if (mock != null) return mock;
        throw new IllegalStateException(MSG + LazyFields.class + "\nProxy: " + proxy);
    }

    public Object mock(Class type) {
        return createMock(type);
    }

    // FIX 2076 CARD Make all Data objects dummies - get rid of this.
    public void mock(BoostField[] fields, LifecycleTestCase testCase) {
        for (int i = 0; i < fields.length; i++) {
            BoostField field = fields[i];
            setMockOnTest(field, testCase);
        }
    }

    private void setMockOnTest(BoostField field, LifecycleTestCase testCase) {
        Class type = field.getType();
        String name = field.getName();
        Object mock = mock(type);
        setField(name, mock, testCase);
    }

    private Object createMock(Class type) {
        Mock mock = mockProvider.mock(type);
        Object proxy = mock.proxy();
        mocks.put(proxy, mock);
        return proxy;
    }

    private void setField(String name, Object proxy, LifecycleTestCase testCase) {
        fielder.setInstance(testCase, name, proxy);
    }
}
