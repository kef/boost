package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

public final class DefaultFieldInspector implements FieldInspector {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ModifierTestUtil modifiers = new DefaultModifierTestUtil();
    private final Object ref;
    private final Field field;

    public DefaultFieldInspector(Object ref, Field field) {
        this.ref = ref;
        this.field = field;
    }

    public boolean isNull() {
        return fielder.getInstance(ref, field) == null;
    }

    public boolean isFinal() {
        return modifiers.isFinal(field);
    }

    public boolean isUsed() {
        return !isNull() || isFinal();
    }
}
