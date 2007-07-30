package au.net.netstorm.boost.test.field;

import java.lang.reflect.Field;

public final class MockFieldSuffix implements FieldSuffix {
    private static final String MOCK = "Mock";

    public boolean matches(Field field) {
        return field.getName().endsWith(MOCK);
    }

    public String addSuffix(Field field) {
        return field.getName() + MOCK;
    }
}
