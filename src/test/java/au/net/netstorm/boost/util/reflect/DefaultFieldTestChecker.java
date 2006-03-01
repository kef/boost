package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

public final class DefaultFieldTestChecker implements FieldTestChecker {
    private final FieldTestUtil fields = new DefaultFieldTestUtil();

    public void checkPrivateFinalField(Class type, String fieldName) {
        Field field = fields.getDeclaredField(type, fieldName);
        int modifiers = field.getModifiers();
        if (!Modifier.isFinal(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared final.");
        if (Modifier.isPublic(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared private.");
        if (Modifier.isStatic(modifiers)) Assert.fail("Field '" + fieldName + "' cannot be static.");
    }
}
