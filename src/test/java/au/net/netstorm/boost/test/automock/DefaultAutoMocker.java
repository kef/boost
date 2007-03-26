package au.net.netstorm.boost.test.automock;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.Mock;

// SUGGEST Make sure no production code (core, edge or test) is using the nursery, outside of the nursery of course.
class DefaultAutoMocker implements AutoMocker {
    private final Map mocks = new HashMap();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final UsesMocks testCase;
    private final MockProvider mockProvider;

    public DefaultAutoMocker(UsesMocks testCase, MockProvider mockProvider) {
        this.testCase = testCase;
        this.mockProvider = mockProvider;
    }

    public Mock get(Object proxy) {
        Mock mock = (Mock) mocks.get(proxy);
        if (mock != null) return mock;
        throw new IllegalStateException("Mock does not exist for provided proxy.");
    }

    public void mock(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            createMock(fields[i]);
        }
    }

    private void createMock(BoostField field) {
        Class type = field.getType();
        String name = field.getName();
        Object proxy = createMock(type, name);
        setField(name, proxy);
    }

    private Object createMock(Class cls, String name) {
        Mock mock = mockProvider.mock(cls, name);
        Object proxy = mock.proxy();
        mocks.put(proxy, mock);
        return proxy;
    }

    private void setField(String name, Object proxy) {
        fielder.setInstance(testCase, name, proxy);
    }
}
