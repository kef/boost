package au.net.netstorm.boost.test.automock;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.test.field.BoostField;
import org.jmock.Mock;

// SUGGEST Make sure no production code (core, edge or test) is using the nursery, outside of the nursery of course.
public class DefaultAutoMocker implements AutoMocker {
    private static final String MSG = "Mock does not exist for provided proxy.  Make sure to implement ";
    private final Map mocks = new HashMap();
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
        Mock mock = mockProvider.mock(type);
        return proxyAndRecord(mock);
    }

    public Object mock(BoostField field) {
        Class type = field.getType();
        String name = field.getName();
        Mock mock = mockProvider.mock(type, name);
        return proxyAndRecord(mock);
    }

    public Object dummy(BoostField field) {
        Class type = field.getType();
        String name = field.getName();
        return mockProvider.dummy(type, name);
    }

    private Object proxyAndRecord(Mock mock) {
        Object proxy = mock.proxy();
        mocks.put(proxy, mock);
        return proxy;
    }
}
