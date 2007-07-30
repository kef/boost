package au.net.netstorm.boost.test.field;

import java.lang.reflect.Field;

public final class DummyFieldSuffix implements FieldSuffix {
    private static final String DUMMY = "Dummy";

    public boolean matches(Field field) {
        return field.getName().endsWith(DUMMY);
    }

    public String addSuffix(Field field) {
        return field.getName() + DUMMY;
    }
}
