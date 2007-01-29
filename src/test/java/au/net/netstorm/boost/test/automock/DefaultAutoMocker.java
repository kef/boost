package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import org.jmock.Mock;

// SUGGEST Make sure no production code (core, edge or test) is using the nursery, outside of the nursery of course.
class DefaultAutoMocker implements AutoMocker {
    private final Map mocks = new HashMap();
    private final ModifierTestUtil modifiers = new DefaultModifierTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final UsesMocks testCase;
    private final MockProvider mockProvider;

    public DefaultAutoMocker(UsesMocks testCase, MockProvider mockProvider) {
        this.testCase = testCase;
        this.mockProvider = mockProvider;
    }

    public void wireMocks() {
        wireMocks(testCase);
    }

    public Mock getMock(Object proxy) {
        Mock mock = (Mock) mocks.get(proxy);
        if (mock != null) {
            return mock;
        }
        throw new IllegalStateException("Mock does not exist for provided proxy.");
    }

    private void wireMocks(UsesMocks test) {
        Field[] fields = getFields(test);
        for (int i = 0; i < fields.length; i++) {
            tryCreateMock(fields[i]);
        }
    }

    private void tryCreateMock(Field field) {
        Object value = getFieldValue(field);
        if (value != null) {
            return;
        }
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
        if (isFinal) {
            throw new IllegalStateException("Cannot set a final null field with a non null value");
        }
    }

    private Field[] getFields(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return siftOutSyntheticFields(fields);
    }

    // FIX 1665 Do we really need this.
    private Field[] siftOutSyntheticFields(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getName().contains("$")) break;
            result.add(field);
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }

    private Object getFieldValue(Field field) {
        return fielder.getInstance(testCase, field);
    }
}
