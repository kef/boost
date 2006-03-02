package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

import junit.framework.Assert;

public final class DefaultFieldTestChecker implements FieldTestChecker {
    private final FieldTestUtil fielderUtil = new DefaultFieldTestUtil();
    private final ModifierTestChecker modifiers = new DefaultModifierTestChecker();

    public void checkPrivateFinalInstanceField(Class type, String fieldName) {
        // FIXME: SC042 Move to ModifierTestChecker.
        Field declared = fielderUtil.getDeclared(type, fieldName);
        modifiers.checkPrivateFinalInstance(declared);
    }

    // FIXME: SC042 Is this ok?
    public void checkType(Class expectedType, Object ref, String fieldName) {
        Object value = fielderUtil.getInstance(ref, fieldName);
        Class type = value.getClass();
        Assert.assertEquals(expectedType, type);
    }
}
