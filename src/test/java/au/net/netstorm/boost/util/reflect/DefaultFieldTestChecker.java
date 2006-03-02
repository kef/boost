package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

public final class DefaultFieldTestChecker implements FieldTestChecker {
    private final FieldTestUtil fielderUtil = new DefaultFieldTestUtil();
    private final ModifierTestChecker modifiers = new DefaultModifierTestChecker();

    // FIXME: SC042 Remove duplication and tidy.
    // FIXME: SC042 Add the modifier checks to FieldTestUtil.
    // FIXME: SC042 Rename.
    public void checkPrivateFinalField(Class type, String fieldName) {
        Field field = fielderUtil.getDeclared(type, fieldName);
        int modifiers = field.getModifiers();
        if (!Modifier.isFinal(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared final.");
        if (Modifier.isPublic(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared private.");
        if (Modifier.isStatic(modifiers)) Assert.fail("Field '" + fieldName + "' cannot be static.");
    }

    // FIXME: SC042 Complete this.
    private void xxx(Class type, String fieldName) {
        Field declared = fielderUtil.getDeclared(type, fieldName);
//        modifiers.checkPrivate(declared);
        modifiers.checkFinal(declared);
//        modifiers.checkInstance(declared);
    }

    // FIXME: SC042 Is this ok?
    public void checkType(Class expectedType, Object ref, String fieldName) {
        Object value = fielderUtil.getInstance(ref, fieldName);
        Class type = value.getClass();
        Assert.assertEquals(expectedType, type);
    }
}
