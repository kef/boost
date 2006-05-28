package au.net.netstorm.boost.test.primordial;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import au.net.netstorm.boost.test.reflect.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.ModifierTestUtil;
import org.jmock.Mock;

final class DefaultImplicitMocker implements ImplicitMocker {
    private final Map mocks = new HashMap();
    private final ModifierTestUtil modifiers = new DefaultModifierTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockTestCase testCase;
    private final MockProvider mockProvider;

    public DefaultImplicitMocker(MockTestCase testCase, MockProvider mockProvider) {
        this.testCase = testCase;
        this.mockProvider = mockProvider;
    }

    public void wireMocks() {
        wireMocks(testCase);
    }

    public Mock getMock(Object proxy) {
        Mock mock = (Mock) mocks.get(proxy);
        if (mock != null) return mock;
        throw new IllegalStateException("Mock does not exist for provided proxy.");
    }

    private void wireMocks(MockTestCase test) {
        Field[] fields = getDeclaredFields(test);
        for (int i = 0; i < fields.length; i++) {
            tryCreateMock(fields[i]);
        }
    }

    private void tryCreateMock(Field field) {
        Object value = getFieldValue(field);
        if (value != null) return;
        ensureNotFinal(field);
        createMock(field);
    }

    private void createMock(Field field) {
        String name = field.getName();
        Class type = field.getType();
        Object proxy = createMock(type, name);
        setField(name, proxy);
    }

    private Object createMock(Class type, String name) {
        Mock mock = mockProvider.mock(type, name);
        Object proxy = mock.proxy();
        mocks.put(proxy, mock);
        return proxy;
    }

    private void setField(String name, Object proxy) {
        fielder.setInstance(testCase, name, proxy);
    }

    private void ensureNotFinal(Field field) {
        boolean isFinal = modifiers.isFinal(field);
        if (isFinal) throw new IllegalStateException("Cannot set a final null field with a non null value");
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }

    private Object getFieldValue(Field field) {
        return fielder.getInstance(testCase, field);
    }
}
